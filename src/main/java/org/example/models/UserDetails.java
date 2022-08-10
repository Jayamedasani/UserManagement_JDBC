package org.example.models;

import java.util.Objects;

public class UserDetails {
    private int id,addressID;
    private String name,dob,gender;

    public UserDetails(int id, String name, String dob,int addressID, String gender) {
        this.id = id;
        this.addressID = addressID;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return id == that.id && addressID == that.addressID && Objects.equals(name, that.name) && Objects.equals(dob, that.dob) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressID, name, dob, gender);
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", addressID=" + addressID +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
