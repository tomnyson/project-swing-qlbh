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
            String sql = "insert into products (name, description, price, status) values (?,?,?,?)";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setString(1, sp.getName());
            prst.setString(2, sp.getDescription());
            prst.setFloat(3, sp.getPrice());
            prst.setInt(4, sp.getStatus());
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

    public boolean update(CategoryDTO cat) {
        try {
            String sql = "update categorys set code = ?, name = ?, description = ? where id = ?";
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
            String sql = "delete from categorys where id= ?";
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
            String sql = "select * from products";
            PreparedStatement prst = cnn.prepareStatement(sql);
            ResultSet result = prst.executeQuery();
            while (result.next()) {
                SanPhamDTO prodDTO = new SanPhamDTO();
                prodDTO.setId(result.getInt("id"));
                prodDTO.setName(result.getString("name"));
                prodDTO.setDescription(result.getString("description"));
                prodDTO.setPrice(result.getFloat("price"));
                prodDTO.setStatus(result.getInt("status"));
                catList.add(prodDTO);
            }
        } catch (Exception e) {
        }
        return catList;
    }

    public boolean getDetailById() {
        return true;
    }
}
