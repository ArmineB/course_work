package myProject.coursework.petrolExp.dto;

import java.sql.Date;

/**
 * Created by Armine on 12/12/2017.
 */
public class Expenditure {
    private Integer id;
    private Date date;
    private String  brand;
    private Integer mileage;
    private Integer quantity;
    private Integer cost;

    public Expenditure(Integer id, Date date, String brand, Integer mileage, Integer quantity) {
        this.id = id;
        this.date = date;
        this.brand = brand;
        this.mileage = mileage;
        this.quantity = quantity;
    }

    public Expenditure(Integer id, Date date, String brand, Integer mileage, Integer quantity, Integer cost) {
        this.id = id;
        this.date = date;
        this.brand = brand;
        this.mileage = mileage;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Expenditure() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
