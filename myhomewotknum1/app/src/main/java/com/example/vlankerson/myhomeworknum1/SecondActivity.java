package com.example.vlankerson.myhomeworknum1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static String TEXT = "TEXT";

    private TextView mText;
    private Button mClick;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/#q=" + mText.getText().toString()));
            startActivity(browserIntent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mText = findViewById(R.id.twInText);
        mClick = findViewById(R.id.btnClick);

        Bundle bundle = getIntent().getExtras();
        mText.setText(bundle.getString(TEXT));

        mClick.setOnClickListener(mOnClickListener);

    }
}
