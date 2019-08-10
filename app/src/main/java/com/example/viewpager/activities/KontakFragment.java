
package com.example.viewpager.activities;

/*
    Tanggal pengerjaan : 18 Mei 2019
    Nama               : Yolanda Mau
    Nim                : 10116108
    Kelas              : AKB-3
 */




import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.viewpager.R;

public class KontakFragment extends Fragment implements View.OnClickListener {
    View view;
    Button buttontlp, buttonemail, buttonig;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kontak, container, false);

        buttontlp = view.findViewById(R.id.buttontlp);
        buttonemail = view.findViewById(R.id.buttonemail);
        buttonig = view.findViewById(R.id.buttonig);

        buttontlp.setOnClickListener(this);
        buttonemail.setOnClickListener(this);
        buttonig.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttontlp:
                String number = "082236821628";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
                break;
            case R.id.buttonemail:

                String email = "yolandamau02@gmail.com";
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.putExtra(Intent.EXTRA_EMAIL, email);
                intent1.setType("message/rfc822");
                startActivity(intent1);
                break;
            case R.id.buttonig:
                Uri uri = Uri.parse("http://instagram.com/yolandmau_");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                intent2.setPackage("com.instagram.android");

                try {
                    startActivity(intent2);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/yolandmau_")));
                }
                break;
        }

    }
}
