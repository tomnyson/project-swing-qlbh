/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interfaces.UserInterface;
import dto.CategoryDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomnyson
 */
import untils.DBProvider;
import java.sql.*;
import java.util.ArrayList;

public class CategoryDAO {

    private Connection cnn = DBProvider.getSqlConnection();

    public boolean isExist() {
        return true;
    }

    public boolean create(CategoryDTO cat) {
        try {
            String sql = "insert into categories (code, name, description, status) values (?,?,?,?)";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setString(1, cat.getCode());
            prst.setString(2, cat.getName());
            prst.setString(3, cat.getDescription());
            prst.setInt(4, cat.getStatus());
            int result = prst.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("error login");
            return false;
        }
        return false;
    }

    public boolean update(CategoryDTO cat) {
        try {
            String sql = "update categories set code = ?, name = ?, description = ? where id = ?";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setString(1, cat.getCode());
            prst.setString(2, cat.getName());
            prst.setString(3, cat.getDescription());
             prst.setInt(4, cat.getId());
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
            String sql = "delete from categories where id= ?";
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
        List<CategoryDTO> catList = new ArrayList<>();
        try {
            String sql = "select * from categories";
            PreparedStatement prst = cnn.prepareStatement(sql);
            ResultSet result = prst.executeQuery();
            while (result.next()) {
                CategoryDTO catDTO = new CategoryDTO();
                catDTO.setId(result.getInt("id"));
                catDTO.setCode(result.getString("code"));
                catDTO.setName(result.getString("name"));
                catDTO.setDescription(result.getString("description"));
                catDTO.setStatus(result.getInt("status"));
                catList.add(catDTO);

            }
        } catch (Exception e) {
        }
        return catList;
    }

    public boolean getDetailById() {
        return true;
    }
}
