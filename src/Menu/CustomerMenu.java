package Menu;

import User.Customer;

public class CustomerMenu {
    private Customer user;

    public CustomerMenu(Customer user) {
        this.user = user;
        user.login();
    }

    public void menu(){
        int pilihan = 9999;
        while (pilihan != 0){
            switch (pilihan){
                case 1:
                    user.viewProfile();
                case 2:
                    user.rentItem(null);
            }
        }
    }
}
