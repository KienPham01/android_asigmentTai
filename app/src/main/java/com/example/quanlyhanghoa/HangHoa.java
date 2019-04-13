package com.example.quanlyhanghoa;

import java.io.Serializable;

public class HangHoa implements Serializable {
    private int idhanghoa;
    private String tenhanghoa;
    private String nhasanxuat;
    private String loaihang;
    private int gia;
    private String tinhtrang;


    public HangHoa(int idhanghoa, String tenhanghoa, String nhasanxuat, String loaihang, int gia, String tinhtrang) {
        this.idhanghoa = idhanghoa;
        this.tenhanghoa = tenhanghoa;
        this.nhasanxuat = nhasanxuat;
        this.loaihang = loaihang;
        this.gia = gia;
        this.tinhtrang = tinhtrang;
    }

    public int getIdhanghoa() {
        return idhanghoa;
    }

    public void setIdhanghoa(int idhanghoa) {
        this.idhanghoa = idhanghoa;
    }

    public String getTenhanghoa() {
        return tenhanghoa;
    }

    public void setTenhanghoa(String tenhanghoa) {
        this.tenhanghoa = tenhanghoa;
    }

    public String getNhasanxuat() {
        return nhasanxuat;
    }

    public void setNhasanxuat(String nhasanxuat) {
        this.nhasanxuat = nhasanxuat;
    }

    public String getLoaihang() {
        return loaihang;
    }

    public void setLoaihang(String loaihang) {
        this.loaihang = loaihang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
