import java.util.ArrayList;
import java.util.List;

public class Driver {

    static InputCollector input;
    static ContactList contactsList;
    static List<String> commandHistory;

    public static void main(String[] args) {

        contactsList = new ContactList();
        input = new InputCollector();
        commandHistory = new ArrayList<String>();

        while(true)
        {
            MainMenu();
        }

    }

    public static void New() {
        String fullName = input.inputForPrompt("Enter name: ");
        String email = input.inputForPrompt("Enter email: ");
        String phoneType = input.inputForPrompt("Enter your phone type: ");
        String number = input.inputForPrompt("Enter your phone number: ");

        Contact person = new Contact(fullName, email, phoneType, number);

        contactsList.addContact(person);
    }

    public static void MainMenu()
    {
        boolean validCommand = false;
        System.out.println(" ");
        System.out.println("Main Menu:");
        System.out.println("1. new");
        System.out.println("2. list");
        System.out.println("3. show");
        System.out.println("4. find and add number");
        System.out.println("5. history");
        System.out.println("6. quit");

        do {
            String in = input.inputForPrompt("command: ").toLowerCase();
            switch (in) {
                case "new":
                case "1":
                    commandHistory.add(in);
                    validCommand = false;
                    New();
                    break;
//                case "list":
//                    commandHistory.add(in);
//                    validCommand = false;
//                    list();
//                    break;
                case "show":
                case "3":
                    commandHistory.add(in);
                    validCommand = false;
                    show();
                    break;
                case "find":
                case "add":
                case "4":
                    commandHistory.add(in);
                    validCommand = false;
                    find();
                    break;
                case "history":
                case "5":
                    commandHistory.add(in);
                    validCommand = false;
                    history();
                    break;
                case "quit":
                case "6":
                    commandHistory.add(in);
                    validCommand = false;
                    quit();
                    break;
                case "phone":

                    break;
                default:
                    System.out.println("Invalid command");
                    validCommand = true;
            }
        } while (validCommand);
    }

    public static void show()
    {
        int index = Integer.parseInt(input.inputForPrompt("Contact index:")) - 1;
        contactsList.showInfo(index);
    }


//    public static void list(){
//        contactsList.list();
//    }

    public static void find() {
        contactsList.find(input.inputForPrompt("Enter term to search: "));

    }

    public static void quit(){
        System.exit(0);
    }

    public static void history(){

    }

    public static void addPhone() {

    }
}
