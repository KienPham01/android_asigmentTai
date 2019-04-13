package com.example.quanlyhanghoa;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HangHoaAdapter extends  BaseAdapter{

        Context context;
        ArrayList<HangHoa> hangHoaList;


    public HangHoaAdapter(Context context, ArrayList<HangHoa> hangHoaList) {
        this.context = context;
        this.hangHoaList = hangHoaList;
    }

    @Override
    public int getCount() {
        return hangHoaList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView tvten,tvloai,tvgia,tvtrang,tvnhasx,tvidhh;

    }
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.itemhanghoa,parent, false);
        TextView tvname, tvloai, tvgia, tvtrang,tvid,tvnhasx;
        ImageView imgedit,imgdelete;
        tvname = convertView.findViewById(R.id.tvtenhanghoa);
        tvloai = convertView.findViewById(R.id.tvloaihang);
        tvgia = convertView.findViewById(R.id.tvgia);
        tvtrang = convertView.findViewById(R.id.tvtinhtrang);
        tvid=convertView.findViewById(R.id.tvidhanghoa);
        tvnhasx=convertView.findViewById(R.id.tvnhasanxuat);
        imgedit=convertView.findViewById(R.id.imgedit);
        imgdelete=convertView.findViewById(R.id.imgdelete);

       final HangHoa hangHoa = hangHoaList.get(position);
        tvname.setText(hangHoa.getTenhanghoa());
        tvgia.setText(hangHoa.getGia()+"");
        tvloai.setText(hangHoa.getLoaihang());
        tvtrang.setText(hangHoa.getTinhtrang());
        tvid.setText(hangHoa.getIdhanghoa()+"");
        tvnhasx.setText(hangHoa.getNhasanxuat());
        imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,EditHangHoa.class);
                intent.putExtra("dataHangHoa", hangHoa);
                context.startActivity(intent);
            }
        });
        imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xacnhanxoa(hangHoa.getTenhanghoa(),hangHoa);
            }
        });
        return convertView;

    }
    public void xacnhanxoa(final String ten, final HangHoa hangHoa){
        AlertDialog.Builder dialogxoa=new AlertDialog.Builder(context);
        dialogxoa.setMessage("Bạn có muốn xóa hàng hóa "+ten+" không ?");
        dialogxoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(context,DeleteHangHoa.class);
                intent.putExtra("dataHangHoa", hangHoa);
                context.startActivity(intent);

            }
        });
        dialogxoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogxoa.show();
    }



}
