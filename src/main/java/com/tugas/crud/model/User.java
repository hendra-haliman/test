package com.tugas.crud.model;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String customerId;

    private String customerName;
    private String alamat;
    private String nomorHp;
    private String email;

    @Enumerated(EnumType.STRING)
    private Kewarganegaraan kewarganegaraan;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int usia;

     @ElementCollection(targetClass = JenisDevice.class)
     @Enumerated(EnumType.STRING)
     @CollectionTable(name = "jenis_device")
     private List<JenisDevice> jenisDevice;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Kewarganegaraan getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(Kewarganegaraan kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

     public List<JenisDevice> getJenisDevice() {
     return jenisDevice;
     }

     public void setJenisDevice(List<JenisDevice> jenisDevice) {
     this.jenisDevice = jenisDevice;
     }
}
