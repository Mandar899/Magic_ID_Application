package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //setting up 3 components or declaring components
    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //connecting java variables to the components in activity_main.xml
        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        //when the user clicks on the button it will go on this method
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = etID.getText().toString().trim();                                  //gets text from EditText when user clicks submit

                String dob = idNumber.substring(0,6);                                                //date of birth

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender ;                                                                     //gender
                sGender = (gender < 5 ) ? getString(R.string.female) : getString(R.string.male);

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality ;                                                                //nationality
                if(nationality == 0)
                    sNationality = getString(R.string.citizen);
                else
                    sNationality = getString(R.string.resident);
                String text = getString(R.string.dob) + dob + getString(R.string.line) + getString(R.string.gender) + sGender + getString(R.string.line) + getString(R.string.nationality) + sNationality;
                tvResults.setText(text);
                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }
}