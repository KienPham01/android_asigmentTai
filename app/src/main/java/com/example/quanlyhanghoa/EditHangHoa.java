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

public class EditHangHoa extends AppCompatActivity {

    EditText edttenhanghoaedit,edtnhasanxuatedit,edtloaihangedit,edtgiaedit,edttinhtrangedit;
    Button btedit,bthuyedit;
    String url="http://10.16.72.99:81/quanlyhanghoa/edithanghoa.php";
    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hang_hoa);
        AnhXa();
        Gan();
        btedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenhh=edttenhanghoaedit.getText().toString().trim();
                String nhasx=edtnhasanxuatedit.getText().toString().trim();
                String loaihang=edtloaihangedit.getText().toString().trim();
                String gia=edtgiaedit.getText().toString().trim();
                String tinhtrang=edttinhtrangedit.getText().toString().trim();
                if (tenhh.isEmpty() ||nhasx.isEmpty()||loaihang.isEmpty()||gia.isEmpty()||tinhtrang.isEmpty()){
                    Toast.makeText(EditHangHoa.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }else {
                    Edit(url);
                }
            }
        });
        bthuyedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditHangHoa.this,DanhSachHangHoa.class);
                startActivity(intent);
            }
        });
    }

    private void Edit(String url) {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("succes")){
                    Toast.makeText(EditHangHoa.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(EditHangHoa.this,DanhSachHangHoa.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(EditHangHoa.this,"Sửa không thành công",Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditHangHoa.this,"Xảy ra lôi",Toast.LENGTH_SHORT).show();
                Log.e("AAA","Lỗi: "+error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("idedit",String.valueOf(id));
                params.put("tenedit",edttenhanghoaedit.getText().toString().trim());
                params.put("nhasxedit",edtnhasanxuatedit.getText().toString().trim());
                params.put("loaiedit",edtloaihangedit.getText().toString().trim());
                params.put("giaedit",edtgiaedit.getText().toString().trim());
                params.put("tinhtrangedit",edttinhtrangedit.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void Gan() {
        Intent intent=getIntent();
        HangHoa hangHoa=(HangHoa) intent.getSerializableExtra("dataHangHoa");

        id=hangHoa.getIdhanghoa();
        edttenhanghoaedit.setText(hangHoa.getTenhanghoa());
        edtnhasanxuatedit.setText(hangHoa.getNhasanxuat());
        edtloaihangedit.setText(hangHoa.getLoaihang());
        edtgiaedit.setText(hangHoa.getGia()+"");
        edttinhtrangedit.setText(hangHoa.getTinhtrang());


    }

    private void AnhXa() {
        edttenhanghoaedit=findViewById(R.id.edttenhanghoaedit);
        edtnhasanxuatedit=findViewById(R.id.edtnhasanxuatedit);
        edtloaihangedit=findViewById(R.id.edtloaihangedit);
        edtgiaedit=findViewById(R.id.edtgiaedit);
        edttinhtrangedit=findViewById(R.id.edttinhtrangedit);
        btedit=findViewById(R.id.btedit);
        bthuyedit=findViewById(R.id.bthuyedit);
    }
}
