package co.domi.clase14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout emailWrapper, passwordWrapper;
    private Button loginBtn;
    private TextView signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailWrapper = findViewById(R.id.emailWrapper);
        passwordWrapper = findViewById(R.id.passwordWrapper);
        loginBtn = findViewById(R.id.loginBtn);
        signupLink = findViewById(R.id.signupLink);

        loginBtn.setOnClickListener(this::login);
        signupLink.setOnClickListener(this::goToSignup);
    }

    private void login(View v) {
        String email = emailWrapper.getEditText().getText().toString();
        String password = passwordWrapper.getEditText().getText().toString();

        //VALIDACIONES
        if(email.trim().isEmpty()){
             emailWrapper.setError("Escribe un correo");
             return;
        }else emailWrapper.setError(null);

        if(!TextUtil.isValidEmailAddress(email)){
            emailWrapper.setError("Escribe un correo válido");
            return;
        } else passwordWrapper.setError(null);

        if(password.trim().isEmpty()){
            passwordWrapper.setError("Escribe una contraseña");
            return;
        } else passwordWrapper.setError(null);

        //Login

        goToProfile();
    }

    public void goToProfile(){
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
        finish();
    }

    public void goToSignup(View v){
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.enter, R.anim.stay);
    }

}