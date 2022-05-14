/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.plant;

/**
 *
 * @author PHT
 */
public class Plant {
    private int id;
    private String name;
    private int price;
    private String imgPath;
    private String description;
    private int status;
    private Category category;//related field

    public Plant() {
    }

    public Plant(int id, String name, int price, String imgPath, String description, int status, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
