/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Controller.LoginController;
import Item.Mobil;
import Item.Motor;
import JGUI.LoginView;
import User.Customer;
import User.Owner;
import User.User;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author rahma
 */
public class Application {

    /**
     * @return the Owners
     */
    public static ArrayList<Owner> getOwners() {
        return Owners;
    }

    /**
     * @return the Customers
     */
    public static ArrayList<Customer> getCustomers() {
        return Customers;
    }
    //  eksekusi program
    //  menginisiasi program
    //  menjalankan program
    static JFrame mainMenu = new JFrame();
    public static User Account = new Customer();
    private static ArrayList<Owner> Owners = new ArrayList<Owner>();
    private static ArrayList<Customer> Customers = new ArrayList<Customer>();
    
    private static void gaintUserSession(){
        Owners = LoginController.getOwners();
        Customers = LoginController.getCustomers();
        new LoginView().show();
    }
    
    //memulai penggunaan Frame.
    public static void run(){
        gaintUserSession();
    }
    
    //  *as Customer
    //  menu login  -> menu utama   -> browse item          -> item Detail (rent)   -> confimation  <- menu utama
    //                              -> manage rented item   -> item Detail (return) -> confimation  <- manage rented item
    //                              -> TopUp                <- menu utama
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

    /**
     * @return the Account
     */
    public static User getAccount() {
        return Account;
    }
}
