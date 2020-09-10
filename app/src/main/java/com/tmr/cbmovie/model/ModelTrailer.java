package com.tmr.cbmovie.model;

import java.io.Serializable;

/**
 * Created by temanrendy 2020
 */

public class ModelTrailer implements Serializable {

    private String key;
    private String type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
