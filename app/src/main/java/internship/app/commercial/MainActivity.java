package internship.app.commercial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText pass;
    Button btn;
    SharedPreferences sp;
    TextView Acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

    //Action Bar
        getSupportActionBar().hide();
    /**    getSupportActionBar().setTitle("Welcome");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));**/


        email = findViewById(R.id.login_email);
        pass = findViewById(R.id.login_password);
        btn = findViewById(R.id.login_btn);
        Acc = findViewById(R.id.login_reg);
        sp = getSharedPreferences(ConstantSP.PREF,MODE_PRIVATE);

    // Login Button Validations
        btn.setOnClickListener(view -> {
            if(email.getText().toString().isEmpty()){
                email.setError("Enter an Email ID");
                new CommonMethod(view,"Enter an Email ID");
            }
            else if (pass.getText().toString().isEmpty()){
                pass.setError("Enter a Password");
                new CommonMethod(view,"Enter a Password");
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                email.setError("Invalid Email Id");
                new CommonMethod(view,"Invalid Email ID");
            }
            else if(!pass.getText().toString().matches("(?=.*[0-9]).*")){
                pass.setError("Invalid Password");
                new CommonMethod(view,"Password Require Numbers");
            }
            else if(!pass.getText().toString().matches("(?=.*[A-Z]).*")){
                pass.setError("Invalid Password");
                new CommonMethod(view,"Password Require Capital Letters");
            }
            else if(!pass.getText().toString().matches( "(?=.*[a-z]).*")){
                pass.setError("Invalid Password");
                new CommonMethod(view,"Password Require Letters");
            }
           else if(!pass.getText().toString().matches("(?=.*[!@#$%^&*+=?]).*")){
                pass.setError("Invalid Password");
                new CommonMethod(view,"Password Requires Special character");
            }
            else if(pass.length()<8 && pass.length()<15){
                pass.setError("Invalid Password");
                new CommonMethod(view,"Password Length Should be more than 8 Digits and Less Than 15 Digits");
            }
            else {
                new CommonMethod(MainActivity.this, "Log In Successfully");
                //new CommonMethod(view,"Log in Successfully");
                sp.edit().putString(ConstantSP.Email,email.getText().toString()).commit();
                sp.edit().putString(ConstantSP.Pass,pass.getText().toString()).commit();
                new CommonMethod(MainActivity.this,Homeactivity.class);

            }
        });

    //Register String Process
        Acc.setOnClickListener(view -> new CommonMethod(MainActivity.this,Signup.class));

    // Login Button Visibility for Email Field
    /**    email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (email.getText().toString().isEmpty()){
                    email.setError("Enter an Email ID");
                    btn.setVisibility(View.GONE);
                }
                else if (pass.getText().toString().isEmpty()){
                    pass.setError("Enter a Password");
                    btn.setVisibility(View.GONE);
                }
                else{
                    btn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });**/
    // Login Button Visibility for Password Field
    /**    pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (email.getText().toString().isEmpty()){
                    email.setError("Enter an Email ID");
                    btn.setVisibility(View.GONE);
                }
                else if (pass.getText().toString().isEmpty()){
                    pass.setError("Enter a Password");
                    btn.setVisibility(View.GONE);
                }
                else{
                    btn.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });**/


    }
    @Override
    public void onBackPressed(){
        //finish(); //Exit from current page without loosing login credentials
        finishAffinity(); //- to Exit From whole Application
        //System.exit(0); // Exit From Current page but login data remain as usual
        //alertmethod();
    }
    private void alertmethod(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Exit App");
        builder.setMessage("Are You Sure Want To Exit");

        builder.setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.setPositiveButton("YES", (dialogInterface, i) -> finishAffinity());
        builder.show();
    }
}
