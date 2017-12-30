package com.example.lenovo.travelcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by DELL_PC on 07-10-2017.
 */

public class TrainHome extends AppCompatActivity
{
    Button c,w,h;
    int option;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trains_home);
        Intent intent = getIntent();
        if (intent.hasExtra("val")) {
            Bundle bundle = intent.getExtras();
            option = bundle.getInt("val");
        }
        c = (Button) findViewById(R.id.centralbtn);
        //w = (Button) findViewById(R.id.westernbtn);
        //h = (Button) findViewById(R.id.harbourbtn);
        c.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*AlertDialog.Builder mBuilder = new AlertDialog.Builder(TrainHome.this);
                View mView = getLayoutInflater().inflate(R.layout.route_dialog, null);
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();*/
                Intent toy1 = new Intent(getApplicationContext(),TrainCentral.class);
                toy1.putExtra("val",2);
                startActivity(toy1);
            }
        });
    }
}
