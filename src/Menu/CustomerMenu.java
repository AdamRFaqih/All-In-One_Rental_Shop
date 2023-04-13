package Menu;

import User.Customer;

import java.util.Scanner;

public class CustomerMenu extends Customer {


    public CustomerMenu(int userID, String name, String email, String password, String tipe, String phoneNumber, String address) {
        super(userID, name, email, password, tipe, phoneNumber, address);
        this.login();
        System.out.println("Selamat datang, " + this.getName());
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        printMenu();
        System.out.println("Masukan Pilihan Anda: ");
        int pilihan = scanner.nextInt();
        while (pilihan != 0){
            printMenu();
            System.out.println("Masukan Pilihan Anda: ");
            pilihan = scanner.nextInt();
            switch (pilihan){
                case 1:
                    super.viewProfile();
                case 2:
                    super.addtoCart(null);
                case 3:
                    super.returnItem(null);
                case 4:
                    super.rentCartItem();
                case 5:
                    super.viewRentedItem();
            }
        }
    }

    private void printMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Tampilkan Profile Saya");
        System.out.println("2. Pinjam Item");
        System.out.println("3. Return Item");
        System.out.println("4. Lihat Barang Pinjaman Saya");
        System.out.println("0. Exit");
    }

}
