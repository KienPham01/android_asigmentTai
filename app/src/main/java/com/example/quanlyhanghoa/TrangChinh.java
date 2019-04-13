package com.example.quanlyhanghoa;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TrangChinh extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11;
    int gc=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chinh);

        tv1=findViewById(R.id.tvtc1);
        tv2=findViewById(R.id.tvtc2);
        tv3=findViewById(R.id.tvtc3);
        tv4=findViewById(R.id.tvtc4);
        tv5=findViewById(R.id.tvtc5);
        tv6=findViewById(R.id.tvtc6);
        tv7=findViewById(R.id.tvtc7);
        tv8=findViewById(R.id.tvtc8);
        tv9=findViewById(R.id.tvtc9);
        tv10=findViewById(R.id.tvtc10);
        tv11=findViewById(R.id.tvtc11);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gc<=4){
                    if (tv4.getText().toString().equals("Chưa có nội dung")){
                        showdia(tv4);
                        gc++;
                        tv2.setText(String.valueOf(gc));
                    }else{
                        if (tv5.getText().toString().equals("Chưa có nội dung")){
                            showdia(tv5);
                            gc++;
                            tv2.setText(String.valueOf(gc));
                        }else{
                            if (tv6.getText().toString().equals("Chưa có nội dung")){
                                showdia(tv6);
                                gc++;
                                tv2.setText(String.valueOf(gc));
                            }else{
                                if (tv7.getText().toString().equals("Chưa có nội dung")){
                                    showdia(tv7);
                                    gc++;
                                    tv2.setText(String.valueOf(gc));
                                }else{
                                    Toast.makeText(TrangChinh.this,"Đã có tối đa 4 ghi chú",Toast.LENGTH_SHORT).show();

                                }

                            }

                        }

                    }

                }else {
                    Toast.makeText(TrangChinh.this,"đã có tối đa 4 ghi chú",Toast.LENGTH_SHORT).show();
                }



            }

            private void showdia(final TextView textView) {
                final Dialog dialog=new Dialog(TrangChinh.this);
                dialog.setTitle("Thêm ghi chú");
                dialog.setContentView(R.layout.dialog);
                dialog.show();
                final EditText edtgc=dialog.findViewById(R.id.edtghichu);
                Button btgc=dialog.findViewById(R.id.btghichu);
                btgc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String noidung=edtgc.getText().toString();
                        if (noidung.isEmpty()){
                            Toast.makeText(TrangChinh.this,"Vui lòng nhập ghi chú",Toast.LENGTH_SHORT).show();
                        }else {
                            textView.setText(noidung);
                            dialog.cancel();
                        }

                    }
                });
            }

        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView hoten=header.findViewById(R.id.tvhoten);
        Intent intent=getIntent();
        hoten.setText(intent.getStringExtra("hoten"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trang_chinh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            tv4.setText("Chưa có nội dung");
            tv5.setText("Chưa có nội dung");
            tv6.setText("Chưa có nội dung");
            tv7.setText("Chưa có nội dung");
            tv2.setText("0");
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_danhsachhanghoa) {
            Intent intent=new Intent(TrangChinh.this,DanhSachHangHoa.class);
            startActivity(intent);

        } else if (id == R.id.nav_themhanghoa) {
            Intent intent=new Intent(TrangChinh.this,ThemHangHoa.class);
            startActivity(intent);

        } else if (id == R.id.nav_thongtin) {
            Intent intent=new Intent(TrangChinh.this,ThongTin.class);
            startActivity(intent);

        } else if (id == R.id.nav_dangxuat) {
            Intent intent=new Intent(TrangChinh.this,MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
