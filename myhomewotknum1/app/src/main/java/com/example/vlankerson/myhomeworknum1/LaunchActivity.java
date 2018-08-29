package com.example.vlankerson.myhomeworknum1;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {
    private EditText mText;
    private Button mEnter;

    private View.OnClickListener mOnEnterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isTextValid()) {
                showToast(mText.getText());
            }
        }
    };

    private boolean isTextValid() {
        return !TextUtils.isEmpty(mText.getText());
    }

    private void showToast(Editable string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mText = findViewById(R.id.etText);
        mEnter = findViewById(R.id.btnEnter);

    }
}
