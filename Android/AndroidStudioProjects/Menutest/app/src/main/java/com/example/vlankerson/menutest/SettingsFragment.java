package com.example.vlankerson.menutest;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.List;


public class SettingsFragment extends Fragment {

    private RadioButton mGoogle;
    private RadioButton mYandex;
    private RadioButton mBing;
    private SharedPreferencesHelper mSharedPreferensHelper;

    public SettingsFragment() {

    }


    private View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radio_google:
                    setTrueEngine(getString(R.string.google));
                    mYandex.setChecked(false);
                    mBing.setChecked(false);
                    break;
                case R.id.radio_yandex:
                    setTrueEngine(getString(R.string.yandex));
                    mGoogle.setChecked(false);
                    mBing.setChecked(false);
                    break;
                case R.id.radio_bing:
                    setTrueEngine(getString(R.string.bing));
                    mGoogle.setChecked(false);
                    mYandex.setChecked(false);
                    break;
                default:
                    break;
            }
        }
    };




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        mSharedPreferensHelper = new SharedPreferencesHelper(getActivity());

        mGoogle = v.findViewById(R.id.radio_google);
        mYandex = v.findViewById(R.id.radio_yandex);
        mBing = v.findViewById(R.id.radio_bing);

        //set on click listener
        mGoogle.setOnClickListener(radioButtonClickListener);
        mYandex.setOnClickListener(radioButtonClickListener);
        mBing.setOnClickListener(radioButtonClickListener);

        //set cheked
        setRadioButtonCheck();
        return v;
    }


    private void setTrueEngine(String trueEngine) {
        mSharedPreferensHelper.rewrite(trueEngine);

    }

    private void setRadioButtonCheck() {
        List<Engine> engines = mSharedPreferensHelper.getEngins();

        String google = getString(R.string.google);
        String yandex = getString(R.string.yandex);
        String bing = getString(R.string.bing);

        for (Engine e : engines) {
            if (e.getmUsed()) {
                if (e.getmEngine().equalsIgnoreCase(google)) {
                    mGoogle.setChecked(true);
                }
                if (e.getmEngine().equalsIgnoreCase(yandex)) {
                    mYandex.setChecked(true);
                }
                if (e.getmEngine().equalsIgnoreCase(bing)) {
                    mBing.setChecked(true);
                }
            }
        }
    }

}



