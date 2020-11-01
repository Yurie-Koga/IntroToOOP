package miniproject2;

import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> contacts;

    public ContactList() {
        this.contacts = new ArrayList<>();
    }

    public ContactList(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void clear() {
        contacts.clear();
    }

    /**
     * Add a new contact to Contact List
     *
     * @param newContact
     * @return true: success, false: fail
     */
    public boolean add(Contact newContact) {
        if (newContact == null) {
            System.out.println("Invalid information.");
            return false;
        }

        for (Contact c : contacts) {
            if (c.equals(newContact)) {
                System.out.println("Already exists in the contact list.");
                return false;
            }
        }

        contacts.add(newContact);
        return true;
    }

    /**
     * Remove a contact from Contact List
     *
     * @param indexOfContact
     * @return name of the removed contact
     */
    public String remove(int indexOfContact) {
        if (!isExist(indexOfContact)) {
            System.out.println("not fund");
            return "";
        }

        String name = contacts.get(indexOfContact).getName();
        contacts.remove(indexOfContact);
        return name;
    }

    /**
     * Update a contact
     *
     * @param indexOfContact
     * @param contact
     * @return true: success, false: fail
     */
    public boolean update(int indexOfContact, Contact contact) {
        if (!isExist(indexOfContact)) {
//            System.out.println("not fund");
            return false;
        }
        if (contact == null) {
            System.out.println("Invalid information.");
            return false;
        }

        contacts.get(indexOfContact).setName(contact.getName());
        contacts.get(indexOfContact).setPhoneList(contact.getPhoneList());
        contacts.get(indexOfContact).setEmail(contact.getEmail());
        return true;
    }

    /**
     * Check if the contact exist by index
     *
     * @param indexOfContact
     * @return
     */
    public boolean isExist(int indexOfContact) {
        try {
            if (contacts.get(indexOfContact) != null)
                return true;
        } catch (Exception e) {
            // no implements
        }
        return false;
    }

    public int getLastIndex() {
        return (contacts.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contacts.size(); i++) {
            sb.append(i).append(". ").append(contacts.get(i)).append("\n");
        }
        return sb.toString();
    }
}
