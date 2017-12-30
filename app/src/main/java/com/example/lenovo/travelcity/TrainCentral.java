package com.example.lenovo.travelcity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL_PC on 07-10-2017.
 */

public class TrainCentral extends AppCompatActivity
{
    ListView stns;
    int val;
    Button routeOk;
    RadioButton towards1, towards2;
    ArrayList items;
    private final String URL_FOR_LOGIN = "http://192.168.121.1/travelcity/getstation.php";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_central);
        Intent intent = getIntent();
        if (intent.hasExtra("val")) {
            Bundle bundle = intent.getExtras();
            val = bundle.getInt("val");
        }
        Toast.makeText(getApplicationContext(),Integer.toString(val),Toast.LENGTH_LONG).show();
        stns = (ListView) findViewById(R.id.stations);
        generateData();
        stns.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent toy1 = new Intent(getApplicationContext(),TrainCentral.class);
                startActivity(toy1);
            }
        });
    }
    private void generateData()
    {
        items = new ArrayList<StationItem>();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                URL_FOR_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    for (int j = 0; j < 10; j++) {
                        items.add(jsonObject.getJSONArray("stat").getString(j));

                    }
                    StationAdapter adapter = new StationAdapter(getApplicationContext(),items);
                    stns.setAdapter(adapter);


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
                params.put("rid",Integer.toString(val));
                return params;
            }
        };
        AppController.getInstance(getApplicationContext()).addToRequestQueue(strReq,"Train");
    }
}