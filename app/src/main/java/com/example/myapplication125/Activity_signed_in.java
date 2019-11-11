package com.example.myapplication125;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_signed_in extends AppCompatActivity {

    TextView userEmail;
    TextView userEmail1;
    TextView userName;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);
        //mAuth= FirebaseAuth.getInstance();
        currentUser= mAuth.getCurrentUser();

        if(currentUser == null){
            startActivity(MainActivity.createIntent(this));
            finish();
            return;
        }
        userEmail = (TextView) findViewById(R.id.user_email);
        userName = (TextView) findViewById(R.id.user_display_name);
        userEmail.setText(currentUser.getEmail());
        userName.setText(currentUser.getDisplayName());
    }

    public static Intent createIntent(Context context, IdpResponse idpResponse) {
        Intent in = IdpResponse.getIntent(idpResponse);
        in.setClass(context, Activity_signed_in.class);
        return in;
    }
}
