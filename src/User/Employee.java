/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

/**
 *
 * @author rahma
 */
public class Employee extends User {
    
    
    public Employee(int userID, String name, String email, String password, String tipe) {
        super(userID, name, email, password, tipe);
    }

    @Override
    public void login() {
        System.out.println("Owner Login");
    }

    @Override
    public void logout() {
        System.out.println("Owner Logout");
    }
    
    
}
