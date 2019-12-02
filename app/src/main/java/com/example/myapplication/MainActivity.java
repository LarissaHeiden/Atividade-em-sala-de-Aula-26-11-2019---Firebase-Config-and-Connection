package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText editTextLogin, editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editText3Email);
        editTextSenha = findViewById(R.id.editText4Senha);
        firebaseAuth = FirebaseAuth.getInstance();


    }
    public  void login(View view){
        final String login = editTextLogin.getText().toString();
        String senha = editTextLogin.getText().toString();
        firebaseAuth.signOut();

        if (!login.trim().equals("")){
            firebaseAuth.signInWithEmailAndPassword(login,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), " O login foi efetuado com Sucesso", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Falha ao reakizar login"+login, Toast.LENGTH_LONG).show();

                    }
                }
            });
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

            if (firebaseUser!=null){
                Intent intent = new Intent(getApplicationContext(),Principal.class);
                startActivity(intent);
            }
        }

    }
}
}