package com.example.vlankerson.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_toast);
//        Toast.makeText(LaunchActivity.this, "Connection lost", Toast.LENGTH_LONG).show();

    }

    public void btnOnClick(View view) {
        showCustomToast();
    }

    public void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_toast, null);

        TextView text = layout.findViewById(R.id.tvTitle);

        text.setText("This is a custom toast");

        ImageView image = layout.findViewById(R.id.image);
        image.setImageResource(R.mipmap.ic_launcher_round);

        Toast toast = new Toast(this);
        toast.setView(layout);
        toast.setGravity(Gravity.TOP,0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

}
