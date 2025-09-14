package com.freelanceflow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "worker_personal_data")
public class Worker {

    @Id
    private Long workerid;

    private String fullname;
    private String email;
    private String phonenumber;
    private String address;

    // --- Getters ---
    public Long getWorkerid() { return workerid; }
    public String getFullname() { return fullname; }
    public String getEmail() { return email; }
    public String getPhonenumber() { return phonenumber; }
    public String getAddress() { return address; }

    // --- Setters ---
    public void setWorkerid(Long workerid) { this.workerid = workerid; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public void setEmail(String email) { this.email = email; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
    public void setAddress(String address) { this.address = address; }
}

