package miniproject2;

import java.util.Scanner;
import java.util.regex.Pattern;

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

    /**
     * Start app
     */
    public void run() {
        while (true) {
            displayOptions();
            int input = getUserInputInt("Enter your option: ", true);
            if (!exeOption(input))
                break;
        }
    }

    private void displayOptions() {
        System.out.println("+===   Contact App   ===+");
        System.out.println("| 1. List all Contacts  |");
        System.out.println("| 2. Add new Contact    |");
        System.out.println("| 3. Remove Contact     |");
        System.out.println("| 4. Update Contact     |");
        System.out.println("| 5. Quit               |");
        System.out.println("| 6. Insert Sample Data |");
        System.out.println("| 7. Clear Contacts     |");
        System.out.println("+=======================+");
    }

    /**
     * Return user input as String
     *
     * @param prompt
     * @param isMandatory true: continue till get a valid input
     * @return a string of input
     */
    private String getUserInputString(String prompt, boolean isMandatory) {
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

    /**
     * Return user input as int
     *
     * @param prompt
     * @param isMandatory true: continue till get a valid input
     * @return an int of input
     */
    private int getUserInputInt(String prompt, boolean isMandatory) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(prompt);
                String input = in.nextLine();
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input.");
                if (!isMandatory)
                    return 0;
            }
        }
    }

    /**
     * Return user input of Phone numbers
     *
     * @return
     */
    private PhoneList getUserInputPhones() {
        PhoneList phoneList = new PhoneList();
        String[][] phones;
        while (true) {
            phones = new String[][]{
                    {"Mobile", getUserInputPhone("Enter Mobile: ", false)},
                    {"Work", getUserInputPhone("Enter Work: ", false)},
                    {"Home", getUserInputPhone("Enter Home: ", false)},
            };

            for (String[] p : phones) {
                if (!p[1].isEmpty() && !p[1].isBlank())
                    phoneList.add(new Phone(p[0], p[1]));
            }
            if (phoneList.getPhones().size() == 0) {
                System.out.println("At lease one phone number is required.");
                continue;
            }
            break;
        }
        return phoneList;
    }

    /**
     * Return user input of a phone number
     *
     * @param prompt
     * @param isMandatory
     * @return
     */
    private String getUserInputPhone(String prompt, boolean isMandatory) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(prompt);
                String input = in.nextLine();
                if (isMandatory && (input.isBlank() || input.isEmpty())) {
                    System.out.println("You must enter this field.");
                    continue;
                }
                if (!input.isEmpty() && !input.isBlank() && !isValidPhone(input)) {
                    System.out.println("Phone Number should be 10 digits split by space or dash (e.g. 123-456-7890).");
                    continue;
                }

                return input;
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private boolean isValidPhone(String phoneNum) {
        Pattern pattern = Pattern.compile("^\\d{3}[\\s-]?\\d{3}[\\s-]?\\d{4}$");
        return (pattern.matcher(phoneNum).find());
    }

    /**
     * Execute each option
     *
     * @param optionNum
     * @return
     */
    private boolean exeOption(int optionNum) {
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
            case 6: // Insert Sample Data
                insertSample();
                break;
            case 7: // Clear Contacts
                contactList.clear();
                break;
            default:
                System.out.println("Enter number between 1 to 6");
                break;
        }
        return true;
    }

    /**
     * Add a new contact
     */
    private void addContact() {
        String name = getUserInputString("Enter Name: ", true);
        PhoneList phoneList = getUserInputPhones();
        String email = getUserInputString("Enter Email: ", false);

        if (contactList.add(new Contact(name, phoneList, email)))
            System.out.println("Successfully added a new contact!");
        System.out.println(contactList);
    }

    /**
     * Remove a contact if it exists
     */
    private void removeContact() {
        System.out.println(contactList);
        int index = getUserInputInt("Enter the index of the contact to remove: ", true);
        String result = contactList.remove(index);

        if (!result.isBlank() && !result.isEmpty())
            System.out.println("Successfully removed " + result + ".");
        System.out.println(contactList);
    }

    /**
     * Update a contact
     */
    private void updateContact() {
        System.out.println(contactList);
        int index = 0;
        while (true) {
            index = getUserInputInt("Enter the index of the contact to update: ", true);
            if (!contactList.isExist(index)) {
                System.out.println("Invalid Input. Enter number between 0 to " + contactList.getLastIndex());
                continue;
            }
            break;
        }

        String name = getUserInputString("Enter Name: ", true);
        PhoneList phoneList = getUserInputPhones();
        String email = getUserInputString("Enter Email: ", false);

        if (contactList.update(index, new Contact(name, phoneList, email)))
            System.out.println("Successfully updated.");
        System.out.println(contactList);
    }

    /**
     * Set sample Data
     */
    private void insertSample() {
        PhoneList pl;
        pl = new PhoneList();
        pl.add(new Phone("Mobile", "1234567890"));
        pl.add(new Phone("Work", "123-456-7890"));
        pl.add(new Phone("Home", "123 456 7890"));
        contactList.add(new Contact("tst1", pl, "email@email.com"));
        contactList.add(new Contact("tst2", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Mobile", "001 002 0003"));
        contactList.add(new Contact("tst3", pl, "email@email.com"));
        contactList.add(new Contact("tst4", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Work", "111 222 3333"));
        contactList.add(new Contact("tst5", pl, "email@email.com"));
        contactList.add(new Contact("tst6", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Home", "444-555-6666"));
        contactList.add(new Contact("tst7", pl, "email@email.com"));
        contactList.add(new Contact("tst8", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Mobile", "070-080-0900"));
        pl.add(new Phone("Home", "070 080 0900"));
        contactList.add(new Contact("tst9", pl, "email@email.com"));
        contactList.add(new Contact("tst10", pl, ""));
        pl = new PhoneList();
        pl.add(new Phone("Work", "9999999999"));
        pl.add(new Phone("Home", "0000000001"));
        contactList.add(new Contact("tst11", pl, "email@email.com"));
        contactList.add(new Contact("tst12", pl, ""));

        System.out.println("Sample data has been inserted.");
        System.out.println(contactList);
    }
}
