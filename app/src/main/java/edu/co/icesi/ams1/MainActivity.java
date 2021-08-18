package edu.co.icesi.ams1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
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



        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new StartActivityForResult(), this::onResult);


        loginIniciarBtn.setOnClickListener(
                (v) -> {
                    //Aqui va mi accion
                    String username = loginUsername.getText().toString();
                    String password = loginPassword.getText().toString();
                    //Toast.makeText(this, username+":"+password, Toast.LENGTH_LONG).show();
                    //INTENT

                    Intent intent = new Intent(this, ProfileActivity.class);
                    intent.putExtra("username",username);

                    launcher.launch(intent);

                }
        );
    }

    private void onResult(ActivityResult result) {
        if(result.getResultCode() == RESULT_CANCELED){
            Toast.makeText(this, "El username no está bien formateado", Toast.LENGTH_LONG).show();
        }else if(result.getResultCode() == RESULT_OK){
            String newuser = result.getData().getExtras().getString("newuser");
            loginUsername.setText(newuser);
        }
    }

}