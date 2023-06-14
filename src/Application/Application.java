/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import JGUI.CustomerMainView;

/**
 *
 * @author rahma
 */
public class Application {
    //exekusi program
    //  menginisiasi program
    //  menjalankan program
    static CustomerMainView mainMenu = new CustomerMainView();
    
    
    //memulai penggunaan Frame.
    
    //  *as Customer
    //  menu login  -> menu utama   -> browse item          -> item Detail (rent)   -> confimation  <- menu utama
    //                              -> manage rented item   -> item Detail (return) -> confimation  <- manage rented item
    //                              -> TopUp                <- menu utama
    public static void run(){
        mainMenu.show();
    }
    //  *as Owner
    //  menu login  -> menu utama   -> manage Item  -> Add Item             <- manage Item
    //                                              -> remove item          <- manage Item
    //                                              -> edit item            <- manage Item
    //                              -> notification -> confirmation return  <- notification
}
