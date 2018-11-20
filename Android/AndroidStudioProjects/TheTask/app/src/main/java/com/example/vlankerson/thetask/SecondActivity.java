package com.example.vlankerson.thetask;

import android.os.Bundle;
import android.provider.Browser;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvOutput;
    private Button mBtnSecond;
    public static String MESAGE;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTvOutput = findViewById(R.id.tvOutput);
        mBtnSecond = findViewById(R.id.btnSecond);

        mBtnSecond.setOnClickListener(mEnterSecondOnClickListener);

        Bundle bundl = getIntent().getExtras();
        mTvOutput.setText(bundl.getString(MESAGE));
    }

    private View.OnClickListener mEnterSecondOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


        }
    };
}
