package com.example.quanlyhanghoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ThemHangHoa extends AppCompatActivity {
    EditText edttenhanghoa,edtnhasanxuat,edtloaihang,edtgia,edttinhtrang;
    Button btthem,bthuy;
    String url="http://10.16.72.99:81/quanlyhanghoa/themhanghoa.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hang_hoa);
        AnhXa();
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenhh=edttenhanghoa.getText().toString().trim();
                String nhasx=edtnhasanxuat.getText().toString().trim();
                String loaihang=edtloaihang.getText().toString().trim();
                String gia=edtgia.getText().toString().trim();
                String tinhtrang=edttinhtrang.getText().toString().trim();
                if (tenhh.isEmpty() ||nhasx.isEmpty()||loaihang.isEmpty()||gia.isEmpty()||tinhtrang.isEmpty()){
                    Toast.makeText(ThemHangHoa.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }else {
                    themhanghoa(url);
                }
            }
        });
        bthuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThemHangHoa.this,TrangChinh.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        edttenhanghoa=findViewById(R.id.edttenhanghoa);
        edtnhasanxuat=findViewById(R.id.edtnhasanxuat);
        edtloaihang=findViewById(R.id.edtloaihang);
        edtgia=findViewById(R.id.edtgia);
        edttinhtrang=findViewById(R.id.edttinhtrang);
        btthem=findViewById(R.id.btthem);
        bthuy=findViewById(R.id.bthuy);
    }
    private void themhanghoa(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("succes")){
                    Toast.makeText(ThemHangHoa.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ThemHangHoa.this,DanhSachHangHoa.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ThemHangHoa.this,"Thêm không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ThemHangHoa.this,"Xảy ra lôi",Toast.LENGTH_SHORT).show();
                Log.e("AAA","Lỗi: "+error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("tenHH",edttenhanghoa.getText().toString().trim());
                params.put("nhasxHH",edtnhasanxuat.getText().toString().trim());
                params.put("loaiHH",edtloaihang.getText().toString().trim());
                params.put("giaHH",edtgia.getText().toString().trim());
                params.put("tinhtrangHH",edttinhtrang.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
