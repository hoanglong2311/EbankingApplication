
package model.bussiness;

import java.io.Serializable;

public class Customer implements Serializable{
    private int idNo;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String address;
    private String password;
    private String photo;
    

    public Customer() {
    }

    public Customer(int idNo, String firstName, String lastName, String phoneNo, String email, String address, String password, String photo) {
        this.idNo = idNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.password = password;
        this.photo = photo;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
