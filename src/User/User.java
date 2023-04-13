package User;

public abstract class User {
    private int userID;
    private String name;
    private String email;
    private String password;
    private String tipe;

    public User(int userID, String name, String email, String password, String tipe) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tipe = tipe;
    }

    public abstract void login();
    public abstract void logout();
    public void viewProfile(){
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}
