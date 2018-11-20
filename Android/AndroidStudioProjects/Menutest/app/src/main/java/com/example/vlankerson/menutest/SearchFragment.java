package com.example.vlankerson.menutest;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class SearchFragment extends Fragment {
    public static String SEARCH_REQUEST = "SEARCH_REQUEST";
    private EditText mText;
    private Button mClick;
    private SharedPreferencesHelper mSharedPreferensHelper;


    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        mText = v.findViewById(R.id.editText);
        mClick = v.findViewById(R.id.btnClick);
        mClick.setOnClickListener(mOnClickListener);

        mSharedPreferensHelper = new SharedPreferencesHelper(getActivity());

        setEnginAndRequest();
        return v;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(SEARCH_REQUEST + mText.getText().toString()));
            startActivity(browserIntent);
        }
    };

    private void setEnginAndRequest() {
        List<Engine> engines = mSharedPreferensHelper.getEngins();

        for (Engine e : engines) {
            if (e.getmUsed()) {
                SEARCH_REQUEST = e.getmRequest();
                break;
            }
        }


    }

}
