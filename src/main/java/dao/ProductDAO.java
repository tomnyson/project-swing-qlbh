/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interfaces.UserInterface;
import dto.CategoryDTO;
import dto.SanPhamDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomnyson
 */
import untils.DBProvider;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {

    private Connection cnn = DBProvider.getSqlConnection();

    public boolean isExist() {
        return true;
    }

    public boolean create(SanPhamDTO sp) {
        try {
            String sql = "insert into products (name, description, price, status, category) values (?,?,?,?,?)";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setString(1, sp.getName());
            prst.setString(2, sp.getDescription());
            prst.setFloat(3, sp.getPrice());
            prst.setInt(4, sp.getStatus());
            prst.setInt(5, sp.getCategory().getId());
            int result = prst.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean update(SanPhamDTO sp) {
        try {
            String sql = "update products set name = ?, description = ?, price = ?, category = ? where id = ?";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setString(1, sp.getName());
            prst.setString(2, sp.getDescription());
            prst.setFloat(3, sp.getPrice());
            prst.setInt(4, sp.getCategory().getId());
             prst.setInt(5, sp.getId());
            int result = prst.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            String sql = "delete from products where id= ?";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setInt(1, id);
            int result = prst.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public List getAll() {
        List<SanPhamDTO> catList = new ArrayList<>();
        try {
            String sql = "select p.*, p.id as catId, cat.name as catName  from products p inner join categorys cat on p.category = cat.id";
            PreparedStatement prst = cnn.prepareStatement(sql);
            ResultSet result = prst.executeQuery();
            while (result.next()) {
                SanPhamDTO prodDTO = new SanPhamDTO();
                prodDTO.setId(result.getInt("id"));
                prodDTO.setName(result.getString("name"));
                prodDTO.setDescription(result.getString("description"));
                prodDTO.setPrice(result.getFloat("price"));
                prodDTO.setStatus(result.getInt("status"));
                CategoryDTO cat = new CategoryDTO(result.getInt("catId"), result.getString("catName"));
                prodDTO.setCategory(cat);
                catList.add(prodDTO);
            }
        } catch (Exception e) {
        }
        return catList;
    }

    public  SanPhamDTO getDetailById(int id) {
       SanPhamDTO prod;
        try {
            String sql = "select p.*, p.id as catId, cat.name as catName  from products p inner join categorys cat on p.category = cat.id where p.id = ?";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setInt(1, id);
            ResultSet result = prst.executeQuery();
            while (result.next()) {
                prod = new SanPhamDTO();
                prod.setId(result.getInt("id"));
                prod.setName(result.getString("name"));
                prod.setDescription(result.getString("description"));
                prod.setPrice(result.getFloat("price"));
                prod.setStatus(result.getInt("status"));
                CategoryDTO cat = new CategoryDTO(result.getInt("catId"), result.getString("catName"));
                prod.setCategory(cat);
                return prod;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
