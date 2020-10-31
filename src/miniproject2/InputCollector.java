package miniproject2;

import java.util.Scanner;

public class InputCollector {
    private ContactList contactList;

    public InputCollector() {
        this.contactList = new ContactList();
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }

    private void defaultContactList() {
        PhoneList pl;
        pl = new PhoneList();
        pl.add(new Phone("Mobile", "asdf"));
        pl.add(new Phone("Work", "1234"));
        pl.add(new Phone("Home", "aaa"));
        contactList.add(new Contact("tst1", pl, "email@email.com"));
        contactList.add(new Contact("tst2", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Mobile", "12345"));
        contactList.add(new Contact("tst3", pl, "email@email.com"));
        contactList.add(new Contact("tst4", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Work", "76543"));
        contactList.add(new Contact("tst5", pl, "email@email.com"));
        contactList.add(new Contact("tst6", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Home", "76543"));
        contactList.add(new Contact("tst7", pl, "email@email.com"));
        contactList.add(new Contact("tst8", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Mobile", "asdf"));
        pl.add(new Phone("Home", "76543"));
        contactList.add(new Contact("tst9", pl, "email@email.com"));
        contactList.add(new Contact("tst10", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Work", "asdf"));
        pl.add(new Phone("Home", "76543"));
        contactList.add(new Contact("tst11", pl, "email@email.com"));
        contactList.add(new Contact("tst12", pl, ""));

        System.out.println("Sample data has been set up.");
    }

    public void runContactApp() {
        while (true) {
            displayOptions();
            int input = getUserInputInt("Enter your option: ", true);
            if (!exeOption(input))
                break;
        }
    }

    public void displayOptions() {
        System.out.println("+===   Contact App   ===+");
        System.out.println("| 1. List all Contacts  |");
        System.out.println("| 2. Add new Contact    |");
        System.out.println("| 3. Remove Contact     |");
        System.out.println("| 4. Update Contact     |");
        System.out.println("| 5. Quit               |");
        System.out.println("| 6. Set Default        |");
        System.out.println("+=======================+");
    }

    public String getUserInputString(String prompt, boolean isMandatory) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(prompt);
                String input = in.nextLine();
                if (isMandatory && (input.isBlank() || input.isEmpty())) {
                    System.out.println("You must enter this field.");
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    public int getUserInputInt(String prompt, boolean isMandatory) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(prompt);
                String input = in.nextLine();
                if (isMandatory && (input.isBlank() || input.isEmpty())) {
                    System.out.println("You must enter this field.");
                    continue;
                }
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    public boolean exeOption(int optionNum) {
        switch (optionNum) {
            case 1: // List all Contacts
                System.out.println(contactList);
                break;
            case 2: // Add new Contact
                addContact();
                break;
            case 3: // Remove Contact
                removeContact();
                break;
            case 4: // Update Contact
                updateContact();
                break;
            case 5: // Quit
                System.out.println("Bye!");
                return false;
            case 6:
                defaultContactList();
                break;
            default:
                System.out.println("Select 1 to 5");
                break;
        }
        return true;
    }

    private void addContact() {
        String name = getUserInputString("Enter Name: ", true);
        PhoneList phoneList = getInputPhones();
        String email = getUserInputString("Enter Email: ", false);
        if (contactList.add(new Contact(name, phoneList, email)))
            System.out.println("Successfully added a new contact!");
        System.out.println(contactList);
    }

    private void removeContact() {
        System.out.println(contactList);
        int index = getUserInputInt("Enter the index of the contact to remove: ", true);
        String result = contactList.remove(index);
        if (!result.isBlank() && !result.isEmpty())
            System.out.println("Successfully removed " + result);
        System.out.println(contactList);
    }

    private void updateContact() {
        System.out.println(contactList);
        int index = 0;
        while (true) {
            index = getUserInputInt("Enter the index of the contact to update: ", true);
            if (index < 0 || (contactList.getContacts().size() - 1) < index) {
                System.out.println("Invalid Input. Enter number between 0 to " + (contactList.getContacts().size() - 1));
                continue;
            }
            break;
        }

        String name = getUserInputString("Enter Name: ", true);
        PhoneList phoneList = getInputPhones();
        String email = getUserInputString("Enter Email: ", false);
        contactList.update(index, new Contact(name, phoneList, email));

        System.out.println("Successfully updated.");
        System.out.println(contactList);
    }

    private PhoneList getInputPhones() {
        PhoneList phoneList = new PhoneList();
        while (true) {
            String mobile = getUserInputString("Enter Mobile: ", false);
            String work = getUserInputString("Enter Work: ", false);
            String home = getUserInputString("Enter Home: ", false);
            if ((mobile.isBlank() && mobile.isEmpty())
                    && (work.isBlank() && work.isEmpty())
                    && (home.isBlank() && home.isEmpty())) {
                System.out.println("At lease one phone number is required.");
                continue;
            }

            if (!mobile.isEmpty() && !mobile.isBlank())
                phoneList.add(new Phone("Mobile", mobile));
            if (!work.isEmpty() && !work.isBlank())
                phoneList.add(new Phone("Work", work));
            if (!home.isEmpty() && !home.isBlank())
                phoneList.add(new Phone("Home", home));
            break;
        }

        return phoneList;
    }
}
