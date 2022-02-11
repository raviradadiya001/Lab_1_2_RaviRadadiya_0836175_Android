package com.example.lab_1_2_raviradadiya_0836175_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab_1_2_raviradadiya_0836175_android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    SQLiteDatabase sqLiteDatabase;

    EditText poname, podescr, poprice;
    Button btnViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnViewProduct = findViewById(R.id.btn_view_product);
        poname = findViewById(R.id.p_name);
        podescr = findViewById(R.id.p_desc);
        poprice = findViewById(R.id.p_price);

        binding.btnAddProduct.setOnClickListener(this);
        sqLiteDatabase = openOrCreateDatabase("product_db", MODE_PRIVATE, null);
        createTable();

        btnViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (" +
                "id INTEGER NOT NULL CONSTRAINT product_pk PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(20) NOT NULL," +
                "descr VARCHAR(200) NOT NULL," +
                "price DOUBLE NOT NULL);";
        sqLiteDatabase.execSQL(sql);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_product:
                addProduct();
                break;
        }


    }

    private void addProduct() {
        String name = binding.pName.getText().toString().trim();
        String descr = binding.pDesc.getText().toString().trim();
        String price = binding.pPrice.getText().toString().trim();

        if (name.isEmpty()) {
            binding.pName.setError("Name field is empty");
            binding.pName.requestFocus();
            return;
        }

        if (descr.isEmpty()) {
            binding.pDesc.setError("Description field is empty");
            binding.pDesc.requestFocus();
            return;
        }

        if (price.isEmpty()) {
            binding.pPrice.setError("Price field is empty");
            binding.pPrice.requestFocus();
            return;
        }

        String sql = "INSERT INTO product (name, descr , price)" +
                "VALUES(?, ?, ?)";
        sqLiteDatabase.execSQL(sql, new String[]{name, descr, price});
        Toast.makeText(this, "Product Added Successfully", Toast.LENGTH_SHORT).show();
        ResetPImage();
    }

    private void ResetPImage() {
        poname.setText("");
        poprice.setText("");
        podescr.setText("");
    }

}