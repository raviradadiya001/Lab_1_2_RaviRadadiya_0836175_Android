// Generated by view binder compiler. Do not edit!
package com.example.lab_1_2_raviradadiya_0836175_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lab_1_2_raviradadiya_0836175_android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnAddProduct;

  @NonNull
  public final Button btnViewProduct;

  @NonNull
  public final EditText pDesc;

  @NonNull
  public final EditText pName;

  @NonNull
  public final EditText pPrice;

  private ActivityMainBinding(@NonNull RelativeLayout rootView, @NonNull Button btnAddProduct,
      @NonNull Button btnViewProduct, @NonNull EditText pDesc, @NonNull EditText pName,
      @NonNull EditText pPrice) {
    this.rootView = rootView;
    this.btnAddProduct = btnAddProduct;
    this.btnViewProduct = btnViewProduct;
    this.pDesc = pDesc;
    this.pName = pName;
    this.pPrice = pPrice;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add_product;
      Button btnAddProduct = ViewBindings.findChildViewById(rootView, id);
      if (btnAddProduct == null) {
        break missingId;
      }

      id = R.id.btn_view_product;
      Button btnViewProduct = ViewBindings.findChildViewById(rootView, id);
      if (btnViewProduct == null) {
        break missingId;
      }

      id = R.id.p_desc;
      EditText pDesc = ViewBindings.findChildViewById(rootView, id);
      if (pDesc == null) {
        break missingId;
      }

      id = R.id.p_name;
      EditText pName = ViewBindings.findChildViewById(rootView, id);
      if (pName == null) {
        break missingId;
      }

      id = R.id.p_price;
      EditText pPrice = ViewBindings.findChildViewById(rootView, id);
      if (pPrice == null) {
        break missingId;
      }

      return new ActivityMainBinding((RelativeLayout) rootView, btnAddProduct, btnViewProduct,
          pDesc, pName, pPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
