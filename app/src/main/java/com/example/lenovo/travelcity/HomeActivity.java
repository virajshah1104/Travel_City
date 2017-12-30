package com.example.lenovo.travelcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class HomeActivity extends AppCompatActivity
{
    EditText uname;
    String username;
    Spinner ucity;
    Button go;
    int option;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        uname = (EditText) findViewById(R.id.username);
        username = uname.toString();
        ucity = (Spinner)findViewById(R.id.usercity);
        final ArrayAdapter<String> adap = new ArrayAdapter<String>(HomeActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.status_1));
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ucity.setAdapter(adap);
        ucity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                option = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        go = (Button) findViewById(R.id.btngo);
        go.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                /**if (username == null || usercity == null)
                 {
                 Toast.makeText(getApplicationContext(),"Welcome to "+usercity, Toast.LENGTH_SHORT).show();
                 }*/
                //else
                //{
                //Toast.makeText(getApplicationContext(),"Welcome to "+usercity, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("option", option);
                startActivity(intent);
            //}
            }
        });
    }
}
