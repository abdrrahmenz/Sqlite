/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.sqlite;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import id.codinate.sqlite.helper.DatabaseHelper;

public class FormActivity extends AppCompatActivity {

    Spinner spnType;
    EditText edtName, edtPosisi, edtAlamat;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spnType = (Spinner) findViewById(R.id.spn_type);
        edtName = (EditText) findViewById(R.id.edt_nama);
        edtPosisi = (EditText) findViewById(R.id.edt_posisi);
        edtAlamat = (EditText) findViewById(R.id.edt_alamat);
        btnSave = (Button) findViewById(R.id.btn_save);

        String type [] = {"Laki Laki", "Perempuan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, type);
        adapter.
                setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int type = spnType.getSelectedItemPosition()+1;
                Toast.makeText(FormActivity.this, ""+type, Toast.LENGTH_SHORT).show();
                String posisi = edtPosisi.getText().toString();
                String alamat = edtAlamat.getText().toString();

                DatabaseHelper database = new DatabaseHelper(getApplicationContext());
                database.insertTransaction(name, type, posisi, alamat);

                Toast.makeText(getApplicationContext(), "Transaksi "+name+" berhasil disimpan", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
    public void TambahAnggota(View view){

    }

}
