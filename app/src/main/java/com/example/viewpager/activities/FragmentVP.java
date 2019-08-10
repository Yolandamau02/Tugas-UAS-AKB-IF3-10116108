package com.example.viewpager.activities;

/*
    Tanggal pengerjaan : 07 Agustus 2019
    Nama               : Yolanda Mau
    Nim                : 10116108
    Kelas              : AKB-3
 */



public interface FragmentVP {
    interface View {
        void setText(String str);
    }

    interface Presenter {
        void getText();
    }
}