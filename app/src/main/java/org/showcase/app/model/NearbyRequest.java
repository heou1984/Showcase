package org.showcase.app.model;

import com.google.gson.annotations.Expose;

/**
 * Created by hugh on 4/29/14.
 */
public class NearbyRequest {

    @Expose
    private Float lat;
    @Expose
    private Float lng;
    @Expose
    private int withKn;


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

    public int getWithKn() {
        return withKn;
    }

    public void setWithKn(int withKn) {
        this.withKn = withKn;
    }
}
