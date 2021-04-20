/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author tomnyson
 */
public interface UserInterface {
    public boolean isExist();
    public boolean create();
    public boolean update();
    public boolean delete();
    public boolean getAll();
    public boolean getDetailById();
}
