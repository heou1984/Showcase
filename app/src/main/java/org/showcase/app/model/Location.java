
package org.showcase.app.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;


public class Location implements Serializable {

    @Expose
    private Float lat;
    @Expose
    private Float lng;

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

}
