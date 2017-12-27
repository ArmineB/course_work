package myProject.coursework.petrolExp.dto;

import java.sql.Date;

/**
 * Created by Armine on 06/12/2017.
 */
public class PetrolExp {
    private Integer id;
    private Date date;
    private String brand;
    private Integer mileage;
    private Integer g_quantity;
    private Integer price;
    private  Integer cost;

    public PetrolExp(Integer id, Date date, String brand, Integer mileage, Integer g_quantity, Integer price, Integer cost) {
        this.id = id;
        this.date = date;
        this.brand = brand;
        this.mileage = mileage;
        this.g_quantity = g_quantity;
        this.price = price;
        this.cost = cost;
    }
    public PetrolExp(){

    }

    public PetrolExp(Date date, String brand, Integer mileage, Integer g_quantity, Integer price, Integer cost) {
        this.date = date;
        this.brand = brand;
        this.mileage = mileage;
        this.g_quantity = g_quantity;
        this.price = price;
        this.cost = cost;
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

    public Integer getG_quantity() {
        return g_quantity;
    }

    public void setG_quantity(Integer g_quantity) {
        this.g_quantity = g_quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
