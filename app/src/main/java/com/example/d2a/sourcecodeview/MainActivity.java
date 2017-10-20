package com.example.d2a.sourcecodeview;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask k1;
    static  TextView Textsaya;

    ConnectivityManager myConnManager;
    NetworkInfo InfoSaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textsaya = (TextView)findViewById(R.id.textView2);

        myConnManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        InfoSaya = myConnManager.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        if (InfoSaya != null && InfoSaya.isConnected()){
            k1 = new ConnectInternetTask(this);
            k1.execute("http://www.google.com");
        }
    else{
            Toast.makeText(this,"Gak ada koneksi Internet", Toast.LENGTH_SHORT).show();
        }
    }
}

