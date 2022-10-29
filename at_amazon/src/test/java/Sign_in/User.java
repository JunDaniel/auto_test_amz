package Sign_in;

public class User {
    public String IDtc;
    public String username;
    public String password;
    public String message;

    public User() {

    }
    public User(String IDtc, String username, String password, String message) {
        this.IDtc = IDtc;
        this.username = username;
        this.password = password;
        this.message = message;
    }
    public String getIDtc() {
        return IDtc;
    }
    public void setIDtc (String IDtc) {
        this.IDtc = IDtc;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername (String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
