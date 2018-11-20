package com.example.vlankerson.menutest;

import java.io.Serializable;

public class Engine implements Serializable {
    private String mEngine;
    private String mRequest;
    private boolean mUsed;


    public Engine(String mEngine, String mRequest, boolean mUsed) {
        this.mEngine = mEngine;
        this.mRequest = mRequest;
        this.mUsed = mUsed;
    }

    public String getmEngine() {
        return mEngine;
    }

    private void setmEngine(String mEngine) {
        this.mEngine = mEngine;
    }

    public String getmRequest() {
        return mRequest;
    }

    private void setmRequest(String mRequest) {
        this.mRequest = mRequest;
    }

    public boolean getmUsed() {
        return mUsed;
    }

    public void setmUsed(boolean mUsed) {
        this.mUsed = mUsed;
    }
}
