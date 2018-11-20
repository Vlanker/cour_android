package com.example.vlankerson.menutest;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class SharedPreferencesHelper {
    public static final String SHARED_NAME = "SHARED_NAME";
    public static final String ENGINE_KEY = "ENGINE_KEY";
    public static final Type ENGINE_TYPE = new TypeToken<List<Engine>>(){}.getType();

    private SharedPreferences mSharedPreferences;
    private Gson mGson = new Gson();

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
    }

    public List<Engine> getEngins() {
        List<Engine> engines = mGson.fromJson(mSharedPreferences.getString(ENGINE_KEY, ""), ENGINE_TYPE);
        return engines == null ? new ArrayList<Engine>() : engines;
    }

    public boolean addEngine(Engine engine) {
        List<Engine> engines = getEngins();
        for (Engine e : engines) {
            if (e.getmEngine().equalsIgnoreCase(engine.getmEngine())) {
                return false;
            }
        }
        engines.add(engine);
        mSharedPreferences.edit().putString(ENGINE_KEY, mGson.toJson(engines, ENGINE_TYPE)).apply();
        return true;
    }

    public void rewrite(String engine) {
        List<Engine> engines = getEngins();
        for (Engine e : engines) {
            if (e.getmEngine().equalsIgnoreCase(engine)) {
                e.setmUsed(true);
                continue;
            }
            e.setmUsed(false);
        }
        mSharedPreferences.edit().putString(ENGINE_KEY, mGson.toJson(engines, ENGINE_TYPE)).apply();
    }
}
