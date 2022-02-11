package com.example.lab_1_2_raviradadiya_0836175_android;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.example.lab_1_2_raviradadiya_0836175_android.databinding.ActivityMainBinding;
import com.example.lab_1_2_raviradadiya_0836175_android.databinding.ActivityProductBinding;
import com.example.lab_1_2_raviradadiya_0836175_android.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private ActivityProductBinding binding;
    private SQLiteDatabase sqLiteDatabase;

    private List<ProductModel> productModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sqLiteDatabase = openOrCreateDatabase("product_db", MODE_PRIVATE, null);
        productModelList = new ArrayList<>();

        loadProducts();
    }

    private void loadProducts() {
        String sql = "SELECT * FROM product";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                productModelList.add(new ProductModel(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getDouble(3)
                        )
                );
            } while (cursor.moveToNext());
            cursor.close();
        }

        ProductAdapter productAdapter = new ProductAdapter(this, R.layout.list_product, productModelList, sqLiteDatabase);
        binding.lvProduct.setAdapter(productAdapter);
    }
}