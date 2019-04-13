package com.example.quanlyhanghoa;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DanhSachHangHoa extends AppCompatActivity {
    public static String url="http://10.16.72.99:81/quanlyhanghoa/datahanghoa.php";

    private ArrayList<HangHoa> hangHoaArrayList ;
    private ListView listView;
    private HangHoaAdapter hangHoaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_hang_hoa);
        listView = (ListView) findViewById(R.id.lvhanghoa);


        getdata(url);
      //  hangHoaAdapter.notifyDataSetChanged();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




    public void getdata(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hangHoaArrayList= new ArrayList<>();

                for (int i=0;i<response.length();i++){
                    try {

                        JSONObject jsonObject=response.getJSONObject(i);
                        int id = jsonObject.getInt("idhanghoa");
                        String ten = jsonObject.getString("tenhanghoa");
                        String nha = jsonObject.getString("nhasanxuat");
                        String loai = jsonObject.getString("loaihang");
                        int gia = jsonObject.getInt("gia");
                        String tt = jsonObject.getString("tinhtrang");
                        hangHoaArrayList.add(new HangHoa(id, ten,nha,loai,gia,tt));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                hangHoaAdapter= new HangHoaAdapter(DanhSachHangHoa.this,hangHoaArrayList);
                listView.setAdapter(hangHoaAdapter);
                hangHoaAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DanhSachHangHoa.this,"error: "+error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}
