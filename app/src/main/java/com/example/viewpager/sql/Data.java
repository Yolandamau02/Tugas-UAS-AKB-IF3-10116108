package com.example.viewpager.sql;

/*
    Tanggal pengerjaan : 07 Agustus 2019
    Nama               : Yolanda Mau
    Nim                : 10116108
    Kelas              : AKB-3
 */


public class Data {
    private String Id;
    private String Nim;
    private String Nama;
    private String Kelas;
    private String Telp;
    private String Email;
    private String Instagram;


    public Data() {
    }

    public Data(String Id, String Nim, String Nama, String Kelas, String Telp, String Email, String Instagram) {
        this.setNim(Id);
        this.setNim(Nim);
        this.setNama(Nama);
        this.setKelas(Kelas);
        this.setTelp(Telp);
        this.setEmail(Email);
        this.setInstagram(Instagram);

    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNim() {
        return Nim;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getKelas() {
        return Kelas;
    }

    public void setKelas(String kelas) {
        Kelas = kelas;
    }

    public String getTelp() {
        return Telp;
    }

    public void setTelp(String telp) {
        Telp = telp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }
}
