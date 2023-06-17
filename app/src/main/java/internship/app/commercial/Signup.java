package internship.app.commercial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Signup extends AppCompatActivity {


    EditText dateofbirth,name,uid,password,cpassword,contactnum;
    RadioGroup Gen;
    Button signup;
    Calendar calendar;
    Spinner sp;
    String[] cityarray={"Ahmedabad","Amreli","Anand","Aravalli","Banaskantha (Palanpur)","Bharuch","Bhavnagar","Botad","Chhota Udepur","Dahod","Dangs (Ahwa)","Devbhoomi Dwarka","Gandhinagar",
            "Gir Somnath","Jamnagar","Junagadh","Kachchh","Kheda (Nadiad)","Mahisagar","Mehsana","Morbi","Narmada (Rajpipla)","Navsari","Panchmahal (Godhra)","Patan","Porbandar","Rajkot",
            "Sabarkantha (Himmatnagar)","Surat","Surendranagar","Tapi (Vyara)","Vadodara","Valsad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        // Action Bar
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Initializations
        {
        dateofbirth = findViewById(R.id.signup_DOB);
        calendar = Calendar.getInstance();
        name = findViewById(R.id.signup_name);
        uid = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        cpassword = findViewById(R.id.signup_cpassword);
        contactnum = findViewById(R.id.signup_connumber);
        signup = findViewById(R.id.signup_btn);
        Gen = findViewById(R.id.signup_Gender);
        sp = findViewById(R.id.signup_sp);
        }
        // Date of Birth selection and use of datepicker class

        DatePickerDialog.OnDateSetListener dateClick = (datePicker, i, i1, i2) -> {
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            dateofbirth.setText(dateFormat.format(calendar.getTime()));

        };

        dateofbirth.setOnClickListener(view -> {
            DatePickerDialog dialog = new DatePickerDialog(Signup.this, dateClick,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
            dialog.show();
        });

        // Sign Up Validation
        signup.setOnClickListener(view -> {
            if (name.getText().toString().isEmpty()){
                name.setError("Name Can't be Empty");
            }
            else if (uid.getText().toString().isEmpty()){
                uid.setError("User Id Can't be Empty");
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(uid.getText().toString()).matches()){
                uid.setError("Invalid User ID");
            }
            else if (password.getText().toString().isEmpty()){
                password.setError("Password Can't be Empty");
            }
            else if (!password.getText().toString().matches(cpassword.getText().toString())){
                cpassword.setError("Password and Confirm Password Does not Match");
            }
            else if(!password.getText().toString().matches("(?=.*[0-9]).*")){
                password.setError("Password Require Numbers");
            }
            else if(!password.getText().toString().matches("(?=.*[A-Z]).*")){
                password.setError("Password Require Capital Letters");
            }
            else if(!password.getText().toString().matches( "(?=.*[a-z]).*")){
                password.setError("Password Require Letters");
            }
            else if(!password.getText().toString().matches("(?=.*[!@#$%^&*+=?]).*")){
                password.setError("Password Requires Special character");
            }
            else if(password.length()<8 && password.length()<15){
                password.setError("Password Length Should be more than 8 Digits and Less Than 15 Digits");
            }
            else if (cpassword.getText().toString().isEmpty()){
                cpassword.setError("Confirm Password can't be Empty");
            }
            else if (contactnum.getText().toString().isEmpty()){
                contactnum.setError("Enter a Contact Number");
            }
            else if(contactnum.length()!=10){
                contactnum.setError("Contact Number Is Invalid");
            }
            else if(dateofbirth.getText().toString().isEmpty()){
                dateofbirth.setError("Enter Date Of Birth");
            }
            else if(Gen.getCheckedRadioButtonId()==-1){
                new CommonMethod(Signup.this,"Please Select The Gender");
            }
            else {
                /* new CommonMethod(Signup.this,"Account Created Successfully");
                new CommonMethod(Signup.this,MainActivity.class);
                onBackPressed();*/
                if (new ConnectionDetector(Signup.this).isConnectingToInternet()){

                }
                else {
                    new ConnectionDetector(Signup.this).connectiondetect();

                }
            }
        });
        //Adapter for Spinner
        //Dropdown Menu
        {
            ArrayAdapter adapter = new ArrayAdapter(Signup.this, android.R.layout.simple_dropdown_item_1line, cityarray);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
            sp.setAdapter(adapter);
        }
        //On Item Select Listener
        /** sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                new CommonMethod(Signup.this,cityarray[i]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); **/
        //Gender Listener
        Gen.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton RB = findViewById(i);
            new CommonMethod(Signup.this,RB.getText().toString());
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}