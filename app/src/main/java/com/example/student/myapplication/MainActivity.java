package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> arrNhanVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button bt_Nhap;
    ImageButton bt_Xoa;
    EditText et_MaNV, et_TenNV;
    RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_Nhap = (Button) findViewById(R.id.bt_Nhap);
        bt_Xoa = (ImageButton)findViewById(R.id.bt_Xoa);
        et_MaNV = (EditText)findViewById(R.id.et_MaNV);
        et_TenNV = (EditText)findViewById(R.id.et_TenNV);
        genderGroup = (RadioGroup)findViewById(R.id.genderGroup);

        lvNhanVien = (ListView)findViewById(R.id.listView_ds);
        arrNhanVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout,arrNhanVien);
        lvNhanVien.setAdapter(adapter);
        bt_Nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xylynhap();
            }
        });

        bt_Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyxoa();
            }
        });

    }

    private void xulyxoa() {
        for (int i = lvNhanVien.getChildCount() -1; i>=0; i--){
            View v = lvNhanVien.getChildAt(i);
            CheckBox cb = (CheckBox)v.findViewById(R.id.cb_item);
            if(cb.isChecked()){
                arrNhanVien.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }


    private void xylynhap() {
        String manv = et_MaNV.getText() + "";
        String tennv = et_TenNV.getText() + "";
        boolean gioitinh = false;
        if(genderGroup.getCheckedRadioButtonId() == R.id.rb_Nu){
            gioitinh = true;
        }
        NhanVien nv = new NhanVien();
        nv.setId(manv);
        nv.setName(tennv);
        nv.setGender(gioitinh);

        arrNhanVien.add(nv);

        adapter.notifyDataSetChanged();


        et_MaNV.setText("");
        et_TenNV.setText("");
        et_MaNV.requestFocus();
    }
}
