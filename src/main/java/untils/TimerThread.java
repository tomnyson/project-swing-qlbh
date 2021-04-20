/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untils;

/**
 *
 * @author tomnyson
 */
 import java.util.*;

public class TimerThread extends TimerTask{
    private String name;
   public TimerThread(String name) {
       this.name = name;
   }
   public void run() {
      System.out.println("[" + new Date() + "] " + name + ": task executed!");
   }
}
