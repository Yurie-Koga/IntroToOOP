package miniproject2;

import java.util.Objects;

public class Phone {
    private String phoneName;
    private String phoneNumber;

    public Phone(String phoneName, String phoneNumber) {
        this.phoneName = phoneName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
//        if (!phoneNumber.isEmpty() && !phoneNumber.isBlank())
//            return phoneName + "=" + phoneNumber;
//        else
//            return "";
        return phoneName + "=" + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(phoneName, phone.phoneName) &&
                Objects.equals(phoneNumber, phone.phoneNumber);
    }
}
