package com.example.aplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class activity_registro extends AppCompatActivity {

    EditText txtEmail,txtNombre, txtPassword;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtEmail =findViewById(R.id.txtEmail);
        txtNombre =findViewById(R.id.txtNombre);
        txtPassword =findViewById(R.id.txtPassword);
        btnEnviar =findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnviarWs(txtEmail.getText().toString(),txtNombre.getText().toString(),txtPassword.getText().toString());
            }
        });
    }

    private void EnviarWs(final String Email,final String Nombre, final String Password){

        String url = "jdbc:postgresql://localhost:5432/universidad";
        StringRequest postResquest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtEmail.setText(jsonObject.getString("Email"));
                    txtNombre.setText(jsonObject.getString("Nombre"));
                    txtPassword.setText(jsonObject.getString("Password"));
                    Toast.makeText(activity_registro.this,"ID=" + jsonObject.getString("id"),Toast.LENGTH_LONG).show();



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR",error.getMessage());
            }
        })
        {
            protected Map <String,String> getParams(){
                Map <String,String> params  = new HashMap<>();
                params.put("Email",Email);
                params.put("Nombre",Nombre);
                params.put("Password",Password);
                return params;
            }
        }
                ;
        Volley.newRequestQueue(this).add(postResquest);
    }
    private void UpdateWs(final String Email,final String Nombre, final String Password){

        String url = "jdbc:postgresql://localhost:5432/universidad";
        StringRequest postResquest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtEmail.setText(jsonObject.getString("Email"));
                    txtNombre.setText(jsonObject.getString("Nombre"));
                    txtPassword.setText(jsonObject.getString("Password"));
                    Toast.makeText(activity_registro.this,"ID=" + jsonObject.getString("id"),Toast.LENGTH_LONG).show();



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR",error.getMessage());
            }
        })
        {
            protected Map <String,String> getParams(){
                Map <String,String> params  = new HashMap<>();
                params.put("Email",Email);
                params.put("Nombre",Nombre);
                params.put("Password",Password);
                return params;
            }
        }
                ;
        Volley.newRequestQueue(this).add(postResquest);
    }

}