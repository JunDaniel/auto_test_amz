package Order;

public class Address {
    public String IDtc;
    public String fullName;
    public String streetAddress;
    public String city;
    public String zipCode;
    public String phoneNumber;
    public String message;

    public Address() {

    }
    public Address(String IDtc, String fullName, String streetAddress, String city, String zipCode, String phoneNumber, String message) {
        this.IDtc = IDtc;
        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }
    public String getIDtc() {
        return IDtc;
    }
    public void setIDtc (String IDtc) {
        this.IDtc = IDtc;
    }
    public String getfullName() {
        return fullName;
    }
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
    public String getstreetAddress() {
        return streetAddress;
    }
    public void setstreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getcity() {
        return city;
    }
    public void setcity(String city) {
        this.city = city;
    }
    public String getzipCode() {
        return zipCode;
    }
    public void setzipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getphoneNumber() {
        return phoneNumber;
    }
    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getmessage() {
        return message;
    }
    public void setmessage(String message) {
        this.message = message;
    }
}
