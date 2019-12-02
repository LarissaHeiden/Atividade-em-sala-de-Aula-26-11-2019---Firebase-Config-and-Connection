package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText editTextLogin, editTextSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        firebaseAuth = FirebaseAuth.getInstance();

        editTextLogin= findViewById(R.id.login);
        editTextSenha= findViewById(R.id.editTextsenha);
    }

    public void CadastrarNovoUsuario(View view) {

    }

    public void cadastrarNovoUsuario(View view) {
    }
}
