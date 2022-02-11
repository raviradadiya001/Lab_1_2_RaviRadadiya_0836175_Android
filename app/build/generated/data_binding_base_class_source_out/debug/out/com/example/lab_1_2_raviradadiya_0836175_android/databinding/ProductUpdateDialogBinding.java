// Generated by view binder compiler. Do not edit!
package com.example.lab_1_2_raviradadiya_0836175_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lab_1_2_raviradadiya_0836175_android.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProductUpdateDialogBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnUpdateProduct;

  @NonNull
  public final EditText pDesc;

  @NonNull
  public final EditText pName;

  @NonNull
  public final EditText pPrice;

  private ProductUpdateDialogBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnUpdateProduct, @NonNull EditText pDesc, @NonNull EditText pName,
      @NonNull EditText pPrice) {
    this.rootView = rootView;
    this.btnUpdateProduct = btnUpdateProduct;
    this.pDesc = pDesc;
    this.pName = pName;
    this.pPrice = pPrice;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProductUpdateDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProductUpdateDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.product_update_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProductUpdateDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_update_product;
      Button btnUpdateProduct = ViewBindings.findChildViewById(rootView, id);
      if (btnUpdateProduct == null) {
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

      return new ProductUpdateDialogBinding((LinearLayout) rootView, btnUpdateProduct, pDesc, pName,
          pPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}