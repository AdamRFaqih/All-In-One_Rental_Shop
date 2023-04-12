package User;

public abstract class User {
    private int userID;
    private String name;
    private String email;
    private String password;

    public User(int userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public abstract void login();
    public abstract void logout();
    public void viewProfile(){
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
