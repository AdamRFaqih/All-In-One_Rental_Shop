/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Item.Game;
import Item.Item;
import Item.Mobil;
import Item.Motor;
import Item.Movie;
import User.Owner;
import java.util.Scanner;

/**
 *
 * @author rahma
 */
public class OwnerMenu {
    private Owner owner;

    public OwnerMenu(Owner owner) {
        this.owner = owner;
        owner.login();
        System.out.println("Selamat datang, " + owner.getName());
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
                    owner.viewProfile();
                    break;
                case 2:
                    Item newItem = this.createNewItem();
                    owner.addItem(newItem);
                    break;
                case 3:
                    System.out.println("Silahkan Pilih item yang ingin dihapus");
                    owner.viewItemList();
                    int indexItemToRemove = scanner.nextInt();
                    Item itemToRemove = owner.getItemRented().get(indexItemToRemove);
                    if (itemToRemove.isAvailbility()){
                        System.out.println("Barang sedang digunakan, tidak bisa dihapus");
                        break;
                    }
                    owner.removeItem(itemToRemove);
                    break;
                case 4:
                    owner.viewItemList();
                    break;
            }
        }while (pilihan != 0);
    }

    private void printMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Tampilkan Profile Saya");
        System.out.println("2. Tambah Item");
        System.out.println("3. Hapus Item");
        System.out.println("4. Lihat Barang yang bisa di Pinjaman");
        System.out.println("0. Exit");
    }
    
    private Item createNewItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silahkan jenis barang yang akan ditambahkan");
        System.out.println("1. Game");
        System.out.println("2. Movie");
        System.out.println("3. Mobil");
        System.out.println("4. Motor");
        System.out.println("0. Exit");
        int pilihan = scanner.nextInt();
        switch (pilihan){
            case 1:
                String name1 = scanner.nextLine();
                String description1 = scanner.nextLine();
                double rentalChargePerDay1 = scanner.nextDouble();
                String title1 = scanner.nextLine();
                String genre1 = scanner.nextLine();
                String publisher1 = scanner.nextLine();
                String condition1 = scanner.nextLine();
                
                Game newGame = new Game(name1, description1, rentalChargePerDay1, title1, genre1, publisher1, condition1);
                return newGame;
            case 2:
                String name2 = scanner.nextLine();
                String description2 = scanner.nextLine();
                double rentalChargePerDay2 = scanner.nextDouble();
                String title2 = scanner.nextLine();
                String genre2 = scanner.nextLine();
                int releaseYear2 = scanner.nextInt();
                String director2 = scanner.nextLine();
                String condition2 = scanner.nextLine();
                
                Movie newMovie = new Movie(name2, description2, rentalChargePerDay2, title2, genre2, releaseYear2, director2, condition2);
                return newMovie;
            case 3:
                System.out.println("masukan deskripsi mobil");
                scanner.nextLine();
                
                System.out.print("nama :");
                String name3 = scanner.nextLine();
                
                System.out.print("deskripsi :");
                String description3 = scanner.nextLine();
                
                
                System.out.println("biaya rental ");
                double rentalChargePerDay3 = scanner.nextDouble();
                scanner.nextLine();
                
                System.out.print("pabrik ");
                String pabrikan3 = scanner.nextLine();
                
                System.out.print("Model ");
                String model3 = scanner.nextLine();
                
                System.out.print("Tahun ");
                int tahunKeluaran3 = scanner.nextInt();
                
                System.out.print("Bahan bakar ");
                String bahanBakar3 = scanner.nextLine();
                        
                return new Mobil(
                name3,
                description3,
                rentalChargePerDay3,
                pabrikan3,
                model3,
                tahunKeluaran3,
                bahanBakar3
                );
            case 4:
                String name4 =scanner.nextLine();
                String description4 =scanner.nextLine();
                double rentalChargePerDay4 =scanner.nextDouble();
                String pabrikan4 = scanner.nextLine();
                String model4 = scanner.nextLine();
                int tahunKeluar4 = scanner.nextInt();
                      
                return new Motor(
                name4,
                description4,
                rentalChargePerDay4,
                pabrikan4,
                model4,
                tahunKeluar4
                );
        }
        return null;
    }
}
