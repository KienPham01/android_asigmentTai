package com.example.quanlyhanghoa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabLayoutAdapter extends FragmentStatePagerAdapter {
    private String listTab[]={"Phần mềm","Nhà phát triển"};
    private UngDungFragment ungDungFragment;
    private NhaPhatTrienFragment nhaPhatTrienFragment;

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
        ungDungFragment=new UngDungFragment();
        nhaPhatTrienFragment=new NhaPhatTrienFragment();
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0){
            return ungDungFragment;
        }else if (i==1){
            return nhaPhatTrienFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }
    public CharSequence getPageTitle(int i){
        return listTab[i];
    }
}
