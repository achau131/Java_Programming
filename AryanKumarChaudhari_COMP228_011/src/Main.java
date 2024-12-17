import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        showInputDialog();
        MessageDialog();
    }

    public static ArrayList<ScienceBook> scienceBooks = new ArrayList<>();
    public static ArrayList<ChildrenBook> childrenBooks = new ArrayList<>();

    static Scanner userInput = new Scanner(System.in);

    public static void showInputDialog() {
        System.out.println("Which genre Book you want to add? Type 1 for Science Book or Type 2 for Children Book ");
        int genre = userInput.nextInt();

        userInput.nextLine();

        System.out.println("Title of the Book: ");
        String title = userInput.nextLine(); // Use nextLine to allow multi-word titles

        System.out.println("ISBN of the Book: ");
        String ISBN = userInput.nextLine();

        System.out.println("Publisher of the Book: ");
        String publisher = userInput.nextLine();

        System.out.println("Price of the Book: ");
        double price = userInput.nextDouble();

        System.out.println("Year of the Book: ");
        int year = userInput.nextInt();

        if (genre == 1) {

            ScienceBook scienceBook1 = new ScienceBook(title, ISBN, publisher, price, year);
            scienceBooks.add(scienceBook1);
        } else {
            ChildrenBook childrenBook1 = new ChildrenBook(title, ISBN, publisher, price, year);
            childrenBooks.add(childrenBook1);
        }
    }

    public static void MessageDialog() {
        System.out.println("Below are the list of books");
        System.out.println("Science Book");

        for (ScienceBook book : scienceBooks) {
            System.out.println(book.ToString());
        }
        System.out.println("  ");
        System.out.println("Children Book");

        for (ChildrenBook book : childrenBooks) {
            System.out.println(book.ToString());
        }
    }
}
