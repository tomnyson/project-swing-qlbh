/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author tomnyson
 */
public class SanPhamDTO {

    private int id;
    private String name;
    private String description;
    private float price;
    private int status;
    public SanPhamDTO() {
    }
    public SanPhamDTO(String name, String description, float price, int status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public SanPhamDTO(int id, String name, String description, float price, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
