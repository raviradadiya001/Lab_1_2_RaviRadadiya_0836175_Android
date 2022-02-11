package com.example.lab_1_2_raviradadiya_0836175_android;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.lights.LightsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab_1_2_raviradadiya_0836175_android.model.ProductModel;

import java.util.List;

public class ProductAdapter extends ArrayAdapter {
    Context context;
    int layoutRes;
    List<ProductModel> productModelList;
    SQLiteDatabase sqLiteDatabase;

    public ProductAdapter(@NonNull Context context,
                          int resource,
                          @NonNull List<ProductModel> productModelList,
                          SQLiteDatabase sqLiteDatabase
    ) {
        super(context, resource,productModelList);
        this.context = context;
        this.layoutRes = layoutRes;
        this.productModelList = productModelList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = convertView;
        if (v == null) v = inflater.inflate(layoutRes,null);
        TextView nameTV = v.findViewById(R.id.row_name);
        TextView descrTV = v.findViewById(R.id.row_descr);
        TextView priceTV = v.findViewById(R.id.row_price);

        ProductModel productModel = productModelList.get(position);
        nameTV.setText(productModel.getName());
        descrTV.setText(productModel.getDescr());
        priceTV.setText(String.valueOf(productModel.getPrice()));

        v.findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProduct(productModel);
            }
        });

        v.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct(productModel);
            }
        });

        return v;
    }

    private void deleteProduct(ProductModel productModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String sql = "DELETE FROM product WHERE id = ?";
                sqLiteDatabase.execSQL(sql,new Integer[]{productModel.getId()});
                loadProduct();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Product ( " + productModel.getName() + " ) is not deleted. ", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void updateProduct(ProductModel productModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.product_update_dialog,null );
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        EditText nameP = view.findViewById(R.id.p_name);
        EditText descrP = view.findViewById(R.id.p_desc);
        EditText priceP = view.findViewById(R.id.p_price);

        nameP.setText(productModel.getName());
        descrP.setText(productModel.getDescr());
        priceP.setText(String.valueOf(productModel.getPrice()));

        view.findViewById(R.id.btn_update_product).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameP.getText().toString().trim();
                String descr = descrP.getText().toString().trim();
                String price = priceP.getText().toString().trim();

                if(name.isEmpty()){
                    nameP.setError("Name field is empty");
                    nameP.requestFocus();
                    return;
                }

                if(descr.isEmpty()){
                    descrP.setError("Description field is empty");
                    descrP.requestFocus();
                    return;
                }

                if(price.isEmpty()){
                    priceP.setError("Price field is empty");
                    priceP.requestFocus();
                    return;
                }

                String sql = "UPDATE product SET name = ?, descr = ? ,price = ? WHERE id=?";
                sqLiteDatabase.execSQL(sql,
                        new String[]{
                        name,
                        descr,
                        price ,
                        String.valueOf(productModel.getId())}
                );

                loadProduct();
                alertDialog.dismiss();
            }
        });
    }

    private void loadProduct() {
        String sql = "SELECT * FROM product";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        productModelList.clear();
        if (cursor.moveToFirst()){
            do {
                productModelList.add(new ProductModel(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getDouble(3)
                        )
                );
            }while (cursor.moveToNext());
            cursor.close();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return productModelList.size();
    }
}
