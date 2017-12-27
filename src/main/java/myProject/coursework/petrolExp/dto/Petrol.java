package myProject.coursework.petrolExp.dto;

/**
 * Created by Armine on 05/12/2017.
 */
public class Petrol {
    private Integer id;
    private String brand;
    private Integer price;

    public  Petrol(){}

    public Petrol(Integer id, String brand, Integer price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public Petrol(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
