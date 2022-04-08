package com.example.simpledatabaseconnection;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getData() {
        TextView tvResponse = findViewById(R.id.tvResponse);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://davpro.hcproject.nl/simpledatabaseconnection.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tvResponse.setText("Response: " + response);
                    }
                },
                new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvResponse.setText("Error: " + error.getMessage());
                    }
        });

        queue.add(stringRequest);
    }

    public void startRequest(View view) {
        this.getData();
    }
}