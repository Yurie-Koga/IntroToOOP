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

    public boolean add(Contact newContact) {
        if (newContact == null) {
            System.out.println("Invalid information.");
            return false;
        }
        if (isExist(newContact)) {
            System.out.println("Already exists in the contact list.");
            return false;
        }
        contacts.add(newContact);
        return true;
    }

    /**
     * @param indexOfContact
     * @return name of the removed contact
     */
    public String remove(int indexOfContact) {
        if (indexOfContact > contacts.size() - 1) {
            System.out.println("not fund");
        } else {
            String name = contacts.get(indexOfContact).getName();
            contacts.remove(indexOfContact);
            return name;
        }
        return "";
    }

    public void update(int indexOfContact, Contact contact) {
        if (indexOfContact > contacts.size() - 1) {
            System.out.println("not fund");
        } else {
            contacts.get(indexOfContact).setName(contact.getName());
            contacts.get(indexOfContact).setPhoneList(contact.getPhoneList());
            contacts.get(indexOfContact).setEmail(contact.getEmail());
        }
    }

    private boolean isExist(Contact contact) {
        for (Contact c : contacts) {
            if (c.equals(contact)) {
                return true;
            }
        }
        return false;
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
