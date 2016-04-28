/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webPackage;

import java.io.Serializable;

/**
 *
 * @author Ryan
 Guest bean
 */
public class Guest implements Serializable {
    private int userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private int previousVisits;

    public Guest() {
        userID = 0;
        username = null;
        password = null;
        firstName = null;
        lastName = null;
        email = null;
        previousVisits = 0;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPreviousVisits() {
        return previousVisits;
    }

    public void setPreviousVisits(int previousVisits) {
        this.previousVisits = previousVisits;
    }

    public String getFullName() {
        String fullName = "";
        if (firstName != null) {
            fullName += firstName;
        }
        if (firstName != null && lastName != null) {
            fullName += " ";
        }
        if (lastName != null) {
            fullName += lastName;
        }
        return fullName;
    }

}
