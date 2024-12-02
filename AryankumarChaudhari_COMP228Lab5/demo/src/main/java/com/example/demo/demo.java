package com.example.demo;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class demo extends Application {

    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        connectToDatabase();

        TabPane tabPane = new TabPane();

        Tab insertTab = new Tab("Insert Data", createInsertPanel());
        Tab updateTab = new Tab("Update Player", createUpdatePanel());
        Tab reportTab = new Tab("View Reports", createReportPanel());

        tabPane.getTabs().addAll(insertTab, updateTab, reportTab);
        insertTab.setClosable(false);
        updateTab.setClosable(false);
        reportTab.setClosable(false);

        // Scene
        Scene scene = new Scene(tabPane, 800, 600);
        primaryStage.setTitle("Web Survey Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createInsertPanel() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        // Player ID field
        pane.add(new Label("Player ID:"), 0, 0);
        TextField playerId = new TextField();
        pane.add(playerId, 1, 0);

        // Place nodes in the pane for Player details
        pane.add(new Label("First Name:"), 0, 1);
        TextField firstName = new TextField();
        pane.add(firstName, 1, 1);
        pane.add(new Label("Last Name:"), 0, 2);
        TextField lastName = new TextField();
        pane.add(lastName, 1, 2);
        pane.add(new Label("Address:"), 0, 3);
        TextField address = new TextField();
        pane.add(address, 1, 3);
        pane.add(new Label("Postal Code:"), 0, 4);
        TextField postalCode = new TextField();
        pane.add(postalCode, 1, 4);
        pane.add(new Label("Province:"), 0, 5);
        TextField province = new TextField();
        pane.add(province, 1, 5);
        pane.add(new Label("Phone Number:"), 0, 6);
        TextField phoneNumber = new TextField();
        pane.add(phoneNumber, 1, 6);

        // Game Title field (manual entry)
        pane.add(new Label("Game Title:"), 0, 7);
        TextField gameTitle = new TextField();
        pane.add(gameTitle, 1, 7);

        // Fields for PlayerAndGame
        pane.add(new Label("Playing Date (YYYY-MM-DD):"), 0, 8);
        TextField playingDate = new TextField();
        pane.add(playingDate, 1, 8);
        pane.add(new Label("Score:"), 0, 9);
        TextField score = new TextField();
        pane.add(score, 1, 9);

        // Button for saving player details to the database
        Button btnSavePlayer = new Button("Save Player and Game to Database");
        btnSavePlayer.setOnAction(e -> {
            savePlayerToDatabase(playerId.getText(), firstName.getText(), lastName.getText(), address.getText(), postalCode.getText(), province.getText(), phoneNumber.getText());
            saveGameToDatabase(gameTitle.getText());
            savePlayerAndGameToDatabase(playerId.getText(), gameTitle.getText(), playingDate.getText(), score.getText());
        });
        pane.add(btnSavePlayer, 1, 10);
        GridPane.setHalignment(btnSavePlayer, HPos.CENTER);
        GridPane.setValignment(btnSavePlayer, VPos.CENTER);

        return pane;
    }

    private GridPane createUpdatePanel() {


        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(5);
        pane.setVgap(5);

        // ComboBox for selecting Player ID to update
        pane.add(new Label("Player ID:"), 0, 0);
        ComboBox<String> playerIdComboBox = new ComboBox<>();


        loadPlayerIds(playerIdComboBox);
        playerIdComboBox.setPrefWidth(200);
        pane.add(playerIdComboBox, 1, 0);

        // Fields for updating player details
        pane.add(new Label("First Name:"), 0, 1);
        TextField firstName = new TextField();
        pane.add(firstName, 1, 1);
        pane.add(new Label("Last Name:"), 0, 2);
        TextField lastName = new TextField();
        pane.add(lastName, 1, 2);
        pane.add(new Label("Address:"), 0, 3);
        TextField address = new TextField();
        pane.add(address, 1, 3);
        pane.add(new Label("Postal Code:"), 0, 4);
        TextField postalCode = new TextField();
        pane.add(postalCode, 1, 4);
        pane.add(new Label("Province:"), 0, 5);
        TextField province = new TextField();
        pane.add(province, 1, 5);
        pane.add(new Label("Phone Number:"), 0, 6);
        TextField phoneNumber = new TextField();
        pane.add(phoneNumber, 1, 6);

        // Button for updating player details in the database
        Button btnUpdatePlayer = new Button("Update Player in Database");

        btnUpdatePlayer.setOnAction(e -> updatePlayerInDatabase(playerIdComboBox.getValue(), firstName.getText(), lastName.getText(), address.getText(), postalCode.getText(), province.getText(), phoneNumber.getText()));

        pane.add(btnUpdatePlayer, 1, 7);

        GridPane.setHalignment(btnUpdatePlayer, HPos.CENTER);

        GridPane.setValignment(btnUpdatePlayer, VPos.CENTER);

        return pane;
    }

    private VBox createReportPanel() {

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Button viewButton = new Button("View Reports");
        TextArea reportArea = new TextArea();
        reportArea.setEditable(false);

        viewButton.setOnAction(e -> {
            try {
                String query = "SELECT p.player_id, p.first_name, p.last_name, p.address, p.postal_code, p.province, p.phone_number, " +
                        "g.game_title, pg.playing_date, pg.score " +
                        "FROM Player p " +
                        "JOIN PlayerAndGame pg ON p.player_id = pg.player_id " +
                        "JOIN Game g ON pg.game_id = g.game_id " +
                        "ORDER BY p.first_name, p.last_name";

                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                StringBuilder reports = new StringBuilder();
                while (rs.next()) {
                    String report = String.format("Player ID: %d\nName: %s %s\nAddress: %s\nPostal Code: %s\nProvince: %s\nPhone Number: %s\nGame Title: %s\nPlaying Date: %s\nScore: %d\n\n",
                            rs.getInt("player_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("address"),
                            rs.getString("postal_code"),
                            rs.getString("province"),
                            rs.getString("phone_number"),
                            rs.getString("game_title"),
                            rs.getString("playing_date"),
                            rs.getInt("score"));
                    reports.append(report);
                }

                reportArea.setText(reports.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        vbox.getChildren().addAll(viewButton, reportArea);
        return vbox;
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game_management", "root", "Aryan@1700");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayerIds(ComboBox<String> comboBox) {

        try {
            String query = "SELECT player_id FROM Player";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {

                comboBox.getItems().add(rs.getString("player_id"));
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    private void savePlayerToDatabase(String playerId, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {

        String query = "INSERT INTO Player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, playerId);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, address);
            statement.setString(5, postalCode);
            statement.setString(6, province);
            statement.setString(7, phoneNumber);
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private void saveGameToDatabase(String gameTitle) {

        String query = "INSERT INTO Game (game_title) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, gameTitle);
            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private void savePlayerAndGameToDatabase(String playerId, String gameTitle, String playingDate, String score) {

        String query = "INSERT INTO PlayerAndGame (player_id, game_id, playing_date, score) " +
                "SELECT p.player_id, g.game_id, ?, ? " +
                "FROM Player p, Game g " +
                "WHERE p.player_id = ? AND g.game_title = ?";


        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, playingDate);
            statement.setInt(2, Integer.parseInt(score));
            statement.setString(3, playerId);
            statement.setString(4, gameTitle);
            statement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updatePlayerInDatabase(String playerId, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {

        String query = "UPDATE Player SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ? WHERE player_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setString(4, postalCode);
            statement.setString(5, province);
            statement.setString(6, phoneNumber);
            statement.setString(7, playerId);
            statement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
