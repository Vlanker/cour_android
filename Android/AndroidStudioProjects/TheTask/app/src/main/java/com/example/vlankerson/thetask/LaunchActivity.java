package com.example.vlankerson.thetask;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {

    private EditText mInputText;
    private Button mEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mInputText = findViewById(R.id.edInputText);
        mEnter = findViewById(R.id.btnEnter);

        mEnter.setOnClickListener(mEnterOnClickListener);
    }

    private View.OnClickListener mEnterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!isInputTextValid()) {
                showToast(mInputText.getText());

                Intent startSecondaryView = new Intent(LaunchActivity.this, SecondActivity.class);
                startSecondaryView.putExtra(SecondActivity.MESAGE, mInputText.getText().toString());
                startActivity(startSecondaryView);
            }
        }
    };



    private void showToast(Editable text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    private boolean isInputTextValid() {
        return TextUtils.isEmpty(mInputText.getText());
    }
}
