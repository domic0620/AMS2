package edu.co.icesi.ams1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

public class MainActivity extends AppCompatActivity {

    private TextView loginTitle;
    private ImageView loginLogo;
    private EditText loginUsername;
    private EditText loginPassword;
    private Button loginIniciarBtn;

    public static final int CODE = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar
        loginTitle = findViewById(R.id.loginTitle);
        loginLogo = findViewById(R.id.loginLogo);
        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        loginIniciarBtn = findViewById(R.id.loginIniciarBtn);

        loginIniciarBtn.setOnClickListener(
                (v) -> {
                    //Aqui va mi accion
                    String username = loginUsername.getText().toString();
                    String password = loginPassword.getText().toString();
                    Toast.makeText(this, username+":"+password, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, ProfileActivity.class);
                    intent.putExtra("username",username);


                    startActivityForResult(intent, CODE);
                }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == OK && resultCode == RESULT_OK){
            String username = data.getExtras().getString("username");
            loginUsername.setText(username);
        }
    }
}