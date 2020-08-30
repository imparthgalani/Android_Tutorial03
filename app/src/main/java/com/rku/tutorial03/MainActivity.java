package com.rku.tutorial03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtUsername,edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.lblTitle));

        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin    = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String ValUsername = edtUsername.getText().toString();
               String ValPassword = edtPassword.getText().toString();
                Log.i("Login Screen","In Onclick");

               if (ValUsername.equals("admin@gmail.com") && ValPassword.equals("admin")) {
                   Log.i("Login Screen", "in onClick if");

                   Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                   intent.putExtra("userdata",ValUsername);
                   startActivity(intent);
                   finish();

                   Toast.makeText(MainActivity.this,"Login Successfully", Toast.LENGTH_SHORT).show();
               }else {

                   Toast.makeText(MainActivity.this,"Username or Password is wrong.", Toast.LENGTH_SHORT).show();
                   Log.i("Login Screen","In Onclick");
               }
            }
        });
    }
}