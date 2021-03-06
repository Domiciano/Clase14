package co.domi.clase14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignupActivity extends AppCompatActivity {

    private Button signupBtn, closeBtn;
    private TextInputLayout nameWrapper;
    private TextInputLayout emailWrapper;
    private TextInputLayout passwordWrapper;
    private TextInputLayout repasswordWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameWrapper = findViewById(R.id.nameWrapper);
        emailWrapper = findViewById(R.id.emailWrapper);
        passwordWrapper = findViewById(R.id.passwordWrapper);
        repasswordWrapper = findViewById(R.id.repasswordWrapper);
        signupBtn = findViewById(R.id.signupBtn);
        closeBtn = findViewById(R.id.closeBtn);

        signupBtn.setOnClickListener(this::signUp);
        closeBtn.setOnClickListener(this::closeActivity);
    }



    private void signUp(View view) {
        String name = nameWrapper.getEditText().getText().toString();
        String email = emailWrapper.getEditText().getText().toString();
        String password = passwordWrapper.getEditText().getText().toString();
        String repassword = repasswordWrapper.getEditText().getText().toString();

        //Validaciones
        if(name.trim().isEmpty()){
            nameWrapper.setError("Escribe un nombre");
            return;
        }else nameWrapper.setError(null);

        if(email.trim().isEmpty()){
            emailWrapper.setError("Escribe un correo");
            return;
        } else emailWrapper.setError(null);

        if(!TextUtil.isValidEmailAddress(email)){
            emailWrapper.setError("Escribe un correo válido");
            return;
        } else emailWrapper.setError(null);

        if(password.trim().isEmpty()){
            passwordWrapper.setError("Escribe una contraseña");
            return;
        } else passwordWrapper.setError(null);

        if(repassword.trim().isEmpty()){
            repasswordWrapper.setError("Vuelve a escribir la contraseña");
            return;
        } else repasswordWrapper.setError(null);

        if(!password.equals(repassword)){
            repasswordWrapper.setError("La contraseña NO coincide, pilas!");
            return;
        } else repasswordWrapper.setError(null);

        //Signup

    }



    private void closeActivity(View view) {
        onBackPressed();
    }

    //Sobreescribir la accion del boton atras de Android
    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.stay, R.anim.close);
    }


}