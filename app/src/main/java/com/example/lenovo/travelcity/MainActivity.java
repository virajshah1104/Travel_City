package com.example.lenovo.travelcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by DELL_PC on 04-10-2017.
 */

public class MainActivity extends AppCompatActivity
{
    GridView transport;
    int option;
    String name;
    TextView nameview;
    String[] values1 = { "Bus","Train","Flight","Attractions","Hotels","Restaurants"};
    int[] images1 = { R.drawable.bus,R.drawable.train,R.drawable.flight,R.drawable.bus,R.drawable.train,R.drawable.flight};
    private final String URL_FOR_LOGIN = "http://192.168.121.1/travelcity/getcity.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameview = (TextView) findViewById(R.id.cityname);
        //TRANSPORT GRID-VIEW//
        Intent intent = getIntent();
        if (intent.hasExtra("option")) {
            Bundle bundle = intent.getExtras();
            option = bundle.getInt("option");
        }
        if(option == 0)
            nameview.setText("Mumbai");
        else
            nameview.setText("Delhi");

        StringRequest strReq = new StringRequest(Request.Method.POST,
                URL_FOR_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    Toast.makeText(getApplicationContext(), "This is city " + response, Toast.LENGTH_LONG).show();
                    name = response;
                } catch(Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error"," ERROR");
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("cid",Integer.toString(option+1));
                return params;
            }
        };
        AppController.getInstance(getApplicationContext()).addToRequestQueue(strReq,"City");
        transport = (GridView) findViewById(R.id.transportgrid);
        GridAdapter grid1adapt= new GridAdapter(this, values1, images1);
        transport.setAdapter(grid1adapt);
        transport.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                switch(position)
                {
                    //BUSES//
                    case 0 : Toast.makeText(getApplicationContext(),"BUS", Toast.LENGTH_SHORT ).show();
                        break;
                    //TRAINS//
                    case 1 : Intent toy1 = new Intent(getApplicationContext(),TrainHome.class);
                        toy1.putExtra("val",1);
                        startActivity(toy1);
                        break;
                    //FLIGHTS//
                    case 2 : Toast.makeText(getApplicationContext(),"FLIGHT", Toast.LENGTH_SHORT ).show();
                        break;
                    //ATTRACTIONS//
                    case 3 : Toast.makeText(getApplicationContext(),"ATTRACTION", Toast.LENGTH_SHORT ).show();
                        break;
                    //HOTELS//
                    case 4 : Toast.makeText(getApplicationContext(),"HOTELS", Toast.LENGTH_SHORT ).show();
                        break;
                    //RESTAURANTS//
                    case 5 : Toast.makeText(getApplicationContext(),"RESTAURANT", Toast.LENGTH_SHORT ).show();
                        break;
                    default : Toast.makeText(getApplicationContext(),"No Item In GridView!", Toast.LENGTH_SHORT ).show();

                }
            }
        });
    }
}
