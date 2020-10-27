package oop.abstractclasses;

import java.util.Date;

public class Designer extends Employee {
    private boolean hasUXSkills;

    public Designer(String employeeId, long salary, Date startDate, boolean hasUXSkills) {
        super(employeeId, salary, startDate);
        this.hasUXSkills = hasUXSkills;
    }

    public boolean isHasUXSkills() {
        return hasUXSkills;
    }

    @Override
    public void work() {
        System.out.println("Designer working..");
    }

    @Override
    public String toString() {
        return "Designer{" +
                "employeeId='" + super.getEmployeeId() + '\'' +
                ", salary='" + super.getSalary() + '\'' +
                ", startDate='" + super.getStartDate() + '\'' +
                "hasUXSkills=" + hasUXSkills +
                '}';
    }
}
