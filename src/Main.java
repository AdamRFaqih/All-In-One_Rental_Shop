import Item.Mobil;
import Menu.CustomerMenu;
import Menu.OwnerMenu;
import User.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        boolean validate;
        Customer customer = new Customer(
                1,
                "Adam",
                "adamrafif@gmail.com",
                "password",
                "Customer",
                "08129293123",
                "Sukabirus"
        );
        Owner owner = new Owner(
                1,
                "Rahma",
                "raimess@gmail.com",
                "password",
                "Owner",
                "Maju Jawa",
                "Semarang"
        );
        List<User> pengguna = new ArrayList<>();
        pengguna.add(customer);
        pengguna.add(owner);
           
        String endRequest;
        do{ //main loop
            do{
                System.out.print("Masukan Username: ");
                username = scanner.nextLine();
                System.out.print("Masukan Password: ");
                password = scanner.nextLine();
                validate = validatePassword(username,password,pengguna);
            }while (!validate);

            for (User user : pengguna){
                if (user.getName().equals(username) && user.getTipe().equals("Customer")){
                    CustomerMenu customerMenu = new CustomerMenu((Customer) user, owner);
                    customerMenu.menu();
                    break;
                }
                if (user.getName().equals(username) && user.getTipe().equals("Owner")){
                    OwnerMenu ownerMenu = new OwnerMenu((Owner) user);
                    ownerMenu.menu();
                    break;
                }
            }
            System.out.print("Anda ingin keluar atau Ganti akun:(q/s) ");
            endRequest = scanner.nextLine();
        } while (endRequest.equals("s"));
    }

    public static boolean validatePassword(String username, String password, List<User> pengguna){
        for (User user : pengguna){
            if(user.getName().equals(username) && user.getPassword().equals(password)){
                System.out.println("Selamat datang, " + user.getName());
                return true;
            }
        }
        System.out.println("Username atau Password salah");
        return false;
    }
}