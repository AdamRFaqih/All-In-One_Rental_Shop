/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import JGUI.LoginView;
import User.Customer;
import User.Owner;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author rahma
 */
public class Application {
    //  eksekusi program
    //  menginisiasi program
    //  menjalankan program
    static JFrame mainMenu = new JFrame();
    static ArrayList<Owner> Owners = new ArrayList<Owner>();
    static ArrayList<Customer> Customer = new ArrayList<Customer>();
    
    private static void gaintUserSession(){
        
        new LoginView().show();
    }
    
    //memulai penggunaan Frame.
    
    //  *as Customer
    //  menu login  -> menu utama   -> browse item          -> item Detail (rent)   -> confimation  <- menu utama
    //                              -> manage rented item   -> item Detail (return) -> confimation  <- manage rented item
    //                              -> TopUp                <- menu utama
    public static void run(){
        gaintUserSession();
    }
    //  *as Owner
    //  menu login  -> menu utama   -> manage Item  -> Add Item             <- manage Item
    //                                              -> remove item          <- manage Item
    //                                              -> edit item            <- manage Item
    //                              -> notification -> confirmation return  <- notification

    public static void setMainMenu(JFrame menu){
        mainMenu = menu;
    }
    public static JFrame getMainMenu(){
        return mainMenu;
    }
}
