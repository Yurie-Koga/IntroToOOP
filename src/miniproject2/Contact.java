package miniproject2;

import java.util.Objects;

public class Contact {
    private String name;            // mandatory
    private PhoneList phoneList;    // at least one number is required
    private String email;           // non-mandatory

    public Contact(String name, PhoneList phoneList, String email) {
        this.name = name;
        this.phoneList = phoneList;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneList getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(PhoneList phoneList) {
        this.phoneList = phoneList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(name).append("> (");
        sb.append(phoneList);
        if (!email.isEmpty() && !email.isBlank())
            sb.append(", email=").append(email);
        sb.append(')');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(phoneList, contact.phoneList);
    }
}
