package collections.map;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String sin;
    private String name;
    private Date dob;   // date of birth

    public Person(String sin, String name, Date dob) {
        this.sin = sin;
        this.name = name;
        this.dob = dob;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(sin, person.sin) &&
                Objects.equals(name, person.name) &&
                Objects.equals(dob, person.dob);
    }

    // can change values to create a hash code
    @Override
    public int hashCode() {
//        return Objects.hash(sin, name, dob);
        return Objects.hash(sin, name);
//        return 1; // if set a fixed value, HashMap buckets will conflict?
    }

    @Override
    public String toString() {
        return "Person{" +
                "sin='" + sin + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
