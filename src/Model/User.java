package Model;

import java.util.Date;

/**
 * Created by sanjeevbudha on 5/4/16.
 */
public class User {

    int id;
    String firstName;
    String lastName;
    String role;
    boolean status = false;
    Date createdDate;
    Date lastUpdated;
    Date deactivatedDate;
    String mobileNumber;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setDeactivatedDate(Date deactivatedDate) {
        this.deactivatedDate = deactivatedDate;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String phoneNumber;
    String username;
    String password;
    String address;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public Date getDeactivatedDate() {
        return deactivatedDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public User(String fName,String lName,String role,String mNumber,String pNumber,String uName,String password,String address){
        firstName = fName;
        lastName = lName;
        this.role = role;
        status = true;
        mobileNumber = mNumber;
        phoneNumber = pNumber;
        username = uName;
        this.password = password;
        this.address = address;

    }

    public User(){}
}
