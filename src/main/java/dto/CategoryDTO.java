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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tomnyson
 */
public class CategoryDTO {
    private int id;
    private String code;
    private String name;
    private String description;
    private int status;
    public CategoryDTO() {
    }
    public CategoryDTO(String code, String name, String description, int status) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public CategoryDTO(int id, String code, String name, String description, int status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
