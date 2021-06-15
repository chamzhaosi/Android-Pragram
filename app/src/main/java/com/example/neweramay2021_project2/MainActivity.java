package com.example.neweramay2021_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String username = "test@gmail.com", password = "1234";
    private EditText edtUsername, edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setListeners();
    }

    private void findView(){
        edtUsername = findViewById(R.id.etdUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void setListeners(){
        btnLogin.setOnClickListener(view ->{
            //Explicit intent
            String usernameInput = edtUsername.getText().toString();
            String passwordInput = edtPassword.getText().toString();

            if (usernameInput.equals(username) && passwordInput.equals(password)){
                Intent intent = new Intent(MainActivity.this, CoffeOrderActivity.class);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}