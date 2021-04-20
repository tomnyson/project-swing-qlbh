/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interfaces.UserInterface;

/**
 *
 * @author tomnyson
 */
import untils.DBProvider;
import java.sql.*;

public class UserDAO {

    public boolean isExist() {
        return true;
    }

    public boolean checkLogin(String username, String password) {

        try {
            System.out.println(username + " " + password);
            Connection cnn = DBProvider.getSqlConnection();
            String sql = "select count(*) from users where username = ? and password = ?";
            PreparedStatement prst = cnn.prepareStatement(sql);
            prst.setString(1, username);
            prst.setString(2, password);
            ResultSet result = prst.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("error login");
            return false;
        }
        return false;
    }

    public boolean create() {
        return true;
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }

    public boolean getAll() {
        return true;
    }

    public boolean getDetailById() {
        return true;
    }
}
