package oop.abstractclasses;

import java.util.Date;

public class ProductManager extends Employee {
    private String productCode;

    public ProductManager(String employeeId, long salary, Date startDate, String productCode) {
        super(employeeId, salary, startDate);
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    // override abstract method
    @Override
    public void work() {
        System.out.println("PM working...");
    }

    @Override
    public String toString() {
        // w/o 'this' for get methods, still it calls @ Employee class
        return "ProductManager{" +
                "employeeId='" + getEmployeeId() + '\'' +
                ", salary='" + getSalary() + '\'' +
                ", startDate='" + getStartDate() + '\'' +
                "productCode='" + productCode + '\'' +
                '}';
    }
}
