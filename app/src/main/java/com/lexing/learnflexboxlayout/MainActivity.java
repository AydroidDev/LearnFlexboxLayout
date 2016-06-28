package com.lexing.learnflexboxlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void test(View view) {
    FlexAttrBottomDialog.showFlexAttrBottomDialog(this,new FlexboxLayout(this));
  }
}
