package Menu;

import User.Customer;

import java.util.Scanner;

public class CustomerMenu {
    private Customer user;

    public CustomerMenu(Customer user) {
        this.user = user;
        user.login();
        System.out.println("Selamat datang, " + user.getName());
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
                    user.viewProfile();
                case 2:
                    user.rentItem(null);
                case 3:
                    user.returnItem(null);
                case 4:
                    user.viewRentedItem();
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
