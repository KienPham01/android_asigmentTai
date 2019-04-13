package com.example.quanlyhanghoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class DeleteHangHoa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_hang_hoa);
        Intent intent=getIntent();
        HangHoa hangHoa=(HangHoa) intent.getSerializableExtra("dataHangHoa");
        final String idhanghoa=hangHoa.getIdhanghoa()+"";
        Log.e("id" ,idhanghoa);
        String urldelete="http://10.16.72.99:81/quanlyhanghoa/deletehanghoa.php";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, urldelete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("succes")){
                    Toast.makeText(DeleteHangHoa.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DeleteHangHoa.this,DanhSachHangHoa.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(DeleteHangHoa.this,"Xóa không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DeleteHangHoa.this,"Xảy ra lôi",Toast.LENGTH_SHORT).show();
                Log.e("AAA","Lỗi: "+error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("iddelete",idhanghoa);

                return params;

            }
        };
        requestQueue.add(stringRequest);
    }

}
