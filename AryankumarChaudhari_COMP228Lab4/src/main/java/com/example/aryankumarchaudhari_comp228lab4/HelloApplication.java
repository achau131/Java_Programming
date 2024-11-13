package com.example.aryankumarchaudhari_comp228lab4;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashSet;

public class HelloApplication extends Application {
    // using hashSet to store collection of unique elements
    private HashSet<String> selectedSubjects = new HashSet<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainWindow) {
        //Setting Title to Registration
        mainWindow.setTitle("Registration");

        // BorderPane Allows you to arrange the layout of application.
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(2));


        //adding space and padding to the grid making it more structured.
        GridPane inputForm = new GridPane();
        inputForm.setHgap(1);
        inputForm.setVgap(1);
        inputForm.setPadding(new Insets(1));


        // creating labels and text fields for student info
        Label _name = new Label("Name:");
        TextField textName = new TextField();
        Label _address = new Label("Address:");
        TextField textAddress = new TextField();
        Label _city = new Label("City:");
        TextField textCity = new TextField();
        Label _province = new Label("Province:");
        TextField textProvince = new TextField();
        Label _postalCode = new Label("Postal Code:");
        TextField textPostalCode = new TextField();
        Label _phone = new Label("Phone Number:");
        TextField textPhone = new TextField();
        Label _email = new Label("Email:");
        TextField textEmail = new TextField();

        //creating checkboxes for additional activities:
        CheckBox _checkboxCouncil = new CheckBox("Student Council");
        CheckBox _checkboxVolunteer = new CheckBox("Volunteer Work");

        //creating radio buttons and a ToggleGroup for major selection
        //creating togglegroup to make sure only one field is selected
        ToggleGroup groupMajor = new ToggleGroup();
        RadioButton radioComputerScience = new RadioButton("Computer Science");
        RadioButton radioBusiness = new RadioButton("Business");
        radioComputerScience.setToggleGroup(groupMajor);
        radioBusiness.setToggleGroup(groupMajor);

        // Responsible for aligning major selection radio buttons horizontally
        //aligining radioButtons
        HBox boxMajor = new HBox(10, radioComputerScience, radioBusiness);


        //creating a ComboBox for courses section
        //giving it a listview
        ComboBox<String> dropdownCourses = new ComboBox<>();
        ListView<String> listCourses = new ListView<>();


        //setting up the preferred height for course list:
        listCourses.setPrefHeight(150);


        //populating ComboBox with courses based on selected major
        radioComputerScience.setOnAction(e -> {
            dropdownCourses.getItems().clear();
            dropdownCourses.getItems().addAll("Python", "C#", "Java");
        });

        radioBusiness.setOnAction(e -> {
            dropdownCourses.getItems().clear();
            dropdownCourses.getItems().addAll("Economics", "Finance", "Marketing");
        });

        // Responsible for adding a selected course to ListView if not already selected:
        dropdownCourses.setOnAction(e -> {
            String course = dropdownCourses.getValue();
            if (course != null && !selectedSubjects.contains(course)) {
                selectedSubjects.add(course);
                listCourses.getItems().add(course);
            }
        });

        //organizing ComboBox and ListView vertically in a VBox
        //Vbox is a layout container
        VBox boxCourses = new VBox(10, dropdownCourses, listCourses);

        // Responsible for adding all input components to the GridPane:
        inputForm.addRow(0, _name, textName);
        inputForm.add(_address, 0, 1);
        inputForm.add(textAddress, 1, 1);
        inputForm.add(_province, 0, 2);
        inputForm.add(textProvince, 1, 2);
        inputForm.add(_city, 0, 3);
        inputForm.add(textCity, 1, 3);
        inputForm.add(_postalCode, 0, 4);
        inputForm.add(textPostalCode, 1, 4);
        inputForm.add(_phone, 0, 5);
        inputForm.add(textPhone, 1, 5);
        inputForm.add(_email, 0, 6);
        inputForm.add(textEmail, 1, 6);
        inputForm.add(_checkboxCouncil, 2, 1);
        inputForm.add(boxMajor, 3, 0);
        inputForm.add(_checkboxVolunteer, 2, 5);
        inputForm.add(boxCourses, 3, 1, 1, 6);

        // == Responsible for creating a TextArea to display all entered information: ==
        TextArea areaDisplay = new TextArea();
        areaDisplay.setEditable(false);
        //  For enabling text wrapping:
        areaDisplay.setWrapText(false);
        // ==  === === === === === === === === === === === === === === === === ===  ==


        //For adjusting the size to enhance readability and scrolling:
        areaDisplay.setPrefSize(1200, 800);


        // Responsible for adding TextArea to a ScrollPane for scrolling if content overflows:
        ScrollPane paneScroll = new ScrollPane(areaDisplay);
        paneScroll.setPrefHeight(150);
        paneScroll.setPrefWidth(600);
        paneScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        paneScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        //Responsible for creating Display button and its action to populate the TextArea with user inputs:
        Button buttonShow = new Button("Display");
        buttonShow.setOnAction(e -> {
            StringBuilder studentInfo = new StringBuilder();
            studentInfo.append(textName.getText()).append(", ");
            studentInfo.append(textAddress.getText()).append(", ");
            studentInfo.append(textCity.getText()).append(", ");
            studentInfo.append(textProvince.getText()).append(", ");
            studentInfo.append(textPostalCode.getText()).append(", ");
            studentInfo.append(textPhone.getText()).append(", ");
            studentInfo.append(textEmail.getText()).append("\n");

            //make sure only one checkbos is selected
            studentInfo.append("Major: ");
            if (radioComputerScience.isSelected())
            {
                studentInfo.append("Computer Science\n");
            } else if (radioBusiness.isSelected())
            {
                studentInfo.append("Business\n");
            }

            studentInfo.append("Courses: ").append(String.join(", ", selectedSubjects)).append("\n");

            studentInfo.append("Activities: ");
            if (_checkboxCouncil.isSelected()) studentInfo.append("Student Council ");
            if (_checkboxVolunteer.isSelected()) studentInfo.append("Volunteer Work");

            areaDisplay.setText(studentInfo.toString());
        });


        // Responsible for center-aligning the Display button using an HBox:
        HBox boxButton = new HBox(buttonShow);
        boxButton.setAlignment(Pos.CENTER);
//        boxButton.setPadding(new Insets(0));


        // Responsible for organizing the Display button and ScrollPane vertically in a VBox
        VBox boxDisplay = new VBox(0, boxButton, paneScroll);
//        boxDisplay.setPadding(new Insets(5));


        // == Responsible for adding input form and display area to the main layout (BorderPane): ==
        // Input form at the center:
        layout.setCenter(inputForm);
        // Display area at the bottom:
        layout.setBottom(boxDisplay);
        // ==  === === === === === === ==== === ==== ===== ====  ==== === === === === === === ===  ==


        // Responsible for setting the scene and displaying the main window:
        mainWindow.setScene(new Scene(layout, 800, 400));
        mainWindow.show();
    }
}