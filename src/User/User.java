package User;

public abstract class User {
    private int userID;
    private String userName;
    private String email;
    private transient String password;
    private String tipe;

    public User() {
    }

    public User(int userID, String userName, String email, String password, String tipe) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.tipe = tipe;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
