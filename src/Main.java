import java.util.*;

public class Main {

    static boolean isRunning = true;
    static Scanner scan = new Scanner(System.in);
    static int menuChoice;
    private static List<String> currentList = new ArrayList<String>();

    public static void displayInputPrompt() {

        System.out.println("\nWelcome to your own To-Do list!");
        System.out.println("\nWhat would you like to do?");
        System.out.println("\n[1] Add item to To-Do");
        System.out.println("[2] Remove item from To-Do");
        System.out.println("[3] Show To-Do list");
        System.out.println("[4] Sort To-Do list alphabetically");
        System.out.println("[5]");
        System.out.println("[6]");
        System.out.println("[7] Exit program");
    }

    public static void whatToDo() {

        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        menuChoice = input.nextInt();

        switch (menuChoice) {

            case 1://Add To-Do list item
                System.out.println("Add Item:");
                System.out.println("--------------");
                System.out.println("Enter an item: ");
                String item = scanner.nextLine();
                currentList.add(item);
                break;

            case 2://Remove To-Do list item
                System.out.println("Remove Item:");

                for (int i = 0; i < currentList.size(); i++)
                     {
                         System.out.println(i + 1 + " - " + currentList.get(i));
                     }

                System.out.println("--------------");
                System.out.println("Please enter the number of an item to remove: ");
                int index = scanner.nextInt();

                if ((index-1)<0 || index>currentList.size()) {
                    System.out.println("Invalid input, please use a correct value!");
                }
                else {
                    currentList.remove(index-1);
                }
                break;

            case 3://Show To-Do list items
                System.out.println("Your list currently holds:\n");
                System.out.println(currentList);
                scan.nextLine();
                break;

            case 4:

                currentList.sort((o1, o2) -> o1.compareToIgnoreCase(o2));

                System.out.println("Sorted List:");
                for (String alpha : currentList) {
                    System.out.println(alpha);
                }
                break;

            case 5:

                break;

            case 6:

                break;

            case 7:
                isRunning = false;
                System.out.println("Thank you for using this program!");
                break;

            default:
                System.out.println("Invalid input, please use a correct value!");
                break;
        }
    }

    public static void main(String[] args) {

        while (isRunning) {
            displayInputPrompt();

            try {
                whatToDo();
            }

            catch (InputMismatchException ex) {
                System.out.println("Invalid input, please use a correct value!");
            }
        }
    }
}