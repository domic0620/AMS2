package edu.co.icesi.ams1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    private Button backBtn;
    private EditText newUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String username = getIntent().getExtras().getString("username");


        backBtn = findViewById(R.id.backBtn);
        newUsername = findViewById(R.id.newUsername);

        newUsername.setText(username);

        backBtn.setOnClickListener(
                v->{
                    Intent data = new Intent();
                    data.putExtra("username",newUsername.getText().toString());
                    setResult(RESULT_OK, data);
                    finish();
                }
        );
    }
}