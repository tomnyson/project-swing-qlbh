
import java.util.Timer;
import untils.TimerThread;
import views.loginfrm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tomnyson
 */
public class main {
    public static void main(String[] args) {
//        TimerThread t1 = new TimerThread("task here");
//        Timer t = new Timer();
//         t.schedule(t1, 1000, 2000);
        loginfrm frm = new loginfrm();
        frm.setVisible(true);
       
        
    }
}
