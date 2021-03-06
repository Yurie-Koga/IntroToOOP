package oop.polymorphism;

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

    @Override
    public long getSalary() {
//        return super.getSalary();
        System.out.println("ProductManager class");
        return 7777;
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
