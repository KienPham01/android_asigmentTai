package com.example.quanlyhanghoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static String url="http://10.16.72.99:81/quanlyhanghoa/datataikhoan.php";
    EditText edttaikhoan,edtmatkhau;
    Button btlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edttaikhoan=findViewById(R.id.edttaikhoan);
        edtmatkhau=findViewById(R.id.edtmatkhau);
        btlogin=findViewById(R.id.btlogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(url);
            }
        });
    }
    public void login(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                boolean trangthai=false;


                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                        if (object.getString("username").equals(edttaikhoan.getText().toString())==true){
                            if (object.getString("password").equals(edtmatkhau.getText().toString())==true){
                                trangthai=true;
                                Toast.makeText(MainActivity.this,"Login thành công",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(MainActivity.this,TrangChinh.class);
                                intent.putExtra("hoten",object.getString("hoten"));
                                startActivity(intent);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (trangthai==false){
                    Toast.makeText(MainActivity.this,"Login thất bại",Toast.LENGTH_LONG).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
