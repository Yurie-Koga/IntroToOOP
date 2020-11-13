package oop.polymorphism;

import java.util.Date;

public class DataScientist extends Employee {
    private String databaseCode;

    public DataScientist(String employeeId, long salary, Date startDate, String databaseCode) {
        super(employeeId, salary, startDate);
        this.databaseCode = databaseCode;
    }

    public String getDatabaseCode() {
        return databaseCode;
    }

    public void setDatabaseCode(String databaseCode) {
        this.databaseCode = databaseCode;
    }

    @Override
    public long getSalary() {
//        return super.getSalary();
        System.out.println("DataScientist class");
        return 999;
    }

    @Override
    public String toString() {
        return "DataScientist{" +
                "employeeId='" + super.getEmployeeId() + '\'' +
                ", salary='" + super.getSalary() + '\'' +
                ", startDate='" + super.getStartDate() + '\'' +
                "databaseCode='" + databaseCode + '\'' +
                '}';
    }
}
