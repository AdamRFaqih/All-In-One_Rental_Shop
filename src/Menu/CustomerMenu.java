package Menu;

import Item.Item;
import User.Customer;
import User.Owner;

import java.util.Scanner;

public class CustomerMenu {
    private Customer user;
    private Owner owner;

    public CustomerMenu(Customer user, Owner owner) {
        this.user = user;
        this.owner = owner;
        user.login();
        System.out.println("Selamat datang, " + user.getName());
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do{
            printMenu();
            System.out.println("Masukan Pilihan Anda: ");
            pilihan = scanner.nextInt();
            switch (pilihan){
                case 1:
                    user.viewProfile();
                    break;
                case 2:
                    System.out.println("list barang yang ada di rental station: ");
                    owner.viewItemList(1);
                    System.out.println("Pilihan barang yang ingin anda pinjam! 0 untuk membatalkan");
                    int indexItemToRent = scanner.nextInt();
                    if (indexItemToRent < 0){break;}
                    Item itemToRent = user.getRentedItem().get(indexItemToRent);//butuh try catch
                    if(user.getWallet() < itemToRent.getRentalCharge()){
                        System.out.println("saldo anda tidak cukup, peminjaman gagal.");
                        break;
                    }
                    
                    user.rentItem(itemToRent);
                    itemToRent.setAvailbility();
                    break;
                case 3:
                    System.out.println("barang yang sedang anda pinjam: ");
                    user.viewRentedItem(1);
                    System.out.println("Pilihan barang yang ingin anda kembalikan: ");
                    int indexItemToReturn = scanner.nextInt();
                    if (indexItemToReturn < 0){break;}
                    Item itemToReturn = owner.getItemRented().get(indexItemToReturn);
                    
                    user.returnItem(itemToReturn);
                    itemToReturn.setAvailbility();
                case 4:
                    user.viewRentedItem();
                    break;
                case 5:
                    System.out.print("Masukan nominal yang ingin anda topup: ");
                    long amount = scanner.nextLong();
                    
                    System.out.print("Masukan Password untuk melakukan transaksi: ");
                    String password = scanner.next();
                    if(user.getPassword().equals(password)){
                        System.out.println("Transaksi berhasil, " + user.getName());
                        System.out.println("Saldo Wallet anda: " + user.getWallet());
                    }else{
                        System.out.println("Transaksi gagal, password salah!");
                        break;
                    }
                    
                    user.topUp(amount);
                    break;
            }
        }while (pilihan != 0);
    }

    private void printMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Tampilkan Profile Saya");
        System.out.println("2. Pinjam Item");
        System.out.println("3. Return Item");
        System.out.println("4. Lihat Barang Pinjaman Saya");
        System.out.println("5. TopUp your Wallet");
        System.out.println("0. Exit");
    }

}
