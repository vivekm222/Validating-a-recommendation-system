import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static void addClasses(Scanner scanner, ArrayList<Classes> classes) {
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("")) {
                System.out.println("Finished adding classes.");
                return;
            } else {
                System.out.println("Class added.");
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Classes> classes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------------------------------");
        System.out.println("|                                               |");
        System.out.println("|                   Welcome!                    |");
        System.out.println("|                                               |");
        System.out.println("-------------------------------------------------");
        System.out.println();
        while(true) {
            String input = scanner.nextLine();
            input = input.toLowerCase();

            switch (input) {

                case "exit":
                    return;
                case "help":
                    System.out.println("'exit' - ends the program");
                    System.out.println("'add classes' - add classes and grades to be calculated");
                    System.out.println();
                    break;
                case "add classes":
                    System.out.println("Please enter data in the following format:");
                    System.out.println("<Class name> <Letter grade> <Class credits> <AP/HONORS>");
                    System.out.println("Note: if a class is not honors or AP, do not enter anything for that field.");
                    addClasses(scanner, classes);
                    break;
                case "calculate unweighted":
                    System.out.println("Unweighted GPA is: idfk");
                    System.out.println();
                case "calculate weighted":
                    System.out.println("Weighted GPA is: idfk");
                    System.out.println();
                case "calculate gpa":
                    System.out.println("Weighted GPA is: idfk");
                    System.out.println("Unweighted GPA is: idfk");
                    System.out.println();
                default:
                    System.out.println("Invalid command. Please enter 'help' for a list of valid commands.");
            }
        }
    }
}
