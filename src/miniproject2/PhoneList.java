package miniproject2;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneList {
    private ArrayList<Phone> phones;

    public PhoneList() {
        this.phones = new ArrayList<>();
    }

    public PhoneList(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public void add(Phone newPhone) {
        if (newPhone != null)
            phones.add(newPhone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phones.size(); i++) {
            sb.append(phones.get(i));
            if (i < phones.size() - 1)
                sb.append(", ");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneList phoneList = (PhoneList) o;
        return Objects.equals(phones, phoneList.phones);
    }
}
