package com.lexing.learnflexboxlayout;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import com.google.android.flexbox.FlexboxLayout;

/**
 * Author: mopel
 * Date : 2016/6/28
 */
public class FlexAttrBottomDialog {
  private static BottomSheetDialog sDialog;

  private FlexAttrBottomDialog(Context context, FlexboxLayout layout) {
    sDialog = new BottomSheetDialog(context);
    final View view = LayoutInflater.from(context).inflate(R.layout.dialog_layout_attr, null);
    AppCompatSpinner contentselector = (AppCompatSpinner) view.findViewById(R.id.content_selector);
    AppCompatSpinner alignselector = (AppCompatSpinner) view.findViewById(R.id.align_selector);
    AppCompatSpinner justifyselector = (AppCompatSpinner) view.findViewById(R.id.justify_selector);
    AppCompatSpinner flexwarpselector =
        (AppCompatSpinner) view.findViewById(R.id.flexwarp_selector);
    AppCompatSpinner directionselector =
        (AppCompatSpinner) view.findViewById(R.id.direction_selector);
    contentselector.setAdapter(ArrayAdapter.createFromResource(context,R.array.array_align_content,android.R.layout.simple_list_item_1));
    alignselector.setAdapter(ArrayAdapter.createFromResource(context,R.array.array_align_self,android.R.layout.simple_list_item_1));
    justifyselector.setAdapter(ArrayAdapter.createFromResource(context,R.array.array_justify_content,android.R.layout.simple_list_item_1));
    flexwarpselector.setAdapter(ArrayAdapter.createFromResource(context,R.array.array_flex_wrap,android.R.layout.simple_list_item_1));
    directionselector.setAdapter(ArrayAdapter.createFromResource(context,R.array.array_flex_direction,android.R.layout.simple_list_item_1));

    sDialog.setContentView(view);
    sDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
      @Override public void onDismiss(DialogInterface dialog) {
        sDialog = null;
      }
    });
    sDialog.show();
  }

  public static void showFlexAttrBottomDialog(Context context, FlexboxLayout layout) {
    new FlexAttrBottomDialog(context, layout);
  }
}
