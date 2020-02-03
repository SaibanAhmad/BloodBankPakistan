package com.example.bloodbankpakistan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name,age,email,contact,password,confirmPwd,address;
    Spinner bloodGroup;
    Button signIn;
    ApiModel apiModel;
    ModelImplementation implementation;
    String strBloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        viewCasting();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.B_Groups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroup.setAdapter(adapter);
        bloodGroup.setOnItemSelectedListener(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    private void viewCasting()
    {
        name = findViewById(R.id.fullName);
        age = findViewById(R.id.userAge);
        email = findViewById(R.id.emailID);
        contact = findViewById(R.id.userContactNumber);
        address = findViewById(R.id.userAddress);
        password = findViewById(R.id.userPassword);
        confirmPwd = findViewById(R.id.confirmUserPassword);
        bloodGroup = findViewById(R.id.spinner);
        signIn = findViewById(R.id.signInBtn);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void register()
    {
        String strName = name.getText().toString();
        String strAge = age.getText().toString();

        String strEmail = email.getText().toString();
        String strContact = contact.getText().toString();

        String strBloodGroup = bloodGroup.getSelectedItem().toString();
        String strAddress = address.getText().toString();
        String strPassword = password.getText().toString();
        String strConfrimPWd = confirmPwd.getText().toString();

        if(strName.isEmpty()||strAge.isEmpty()||strContact.isEmpty()||strEmail.isEmpty()||strPassword.isEmpty()||strConfrimPWd.isEmpty()||strBloodGroup.isEmpty()) {
            Toast.makeText(this, "FIll ALL FIELDS", Toast.LENGTH_SHORT).show();
        }
        else
            {
                int contact = Integer.parseInt(strContact);
                int age = Integer.parseInt(strAge) ;
                apiModel = new ApiModel(strName,age,strEmail,contact,strBloodGroup,strAddress,strPassword);
                postInfo(apiModel);
            }
    }
    private void postInfo(ApiModel apiModel)
    {
        Call<ApiModel> call = implementation.getImpl().userRegistration(apiModel);
        call.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                Toast.makeText(RegistrationPage.this, response.code()+"\nRegistered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                Toast.makeText(RegistrationPage.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
