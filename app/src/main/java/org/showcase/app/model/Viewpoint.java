
package org.showcase.app.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Viewpoint implements Serializable{

    @Expose
    private Center center;
    @Expose
    private String city;
    @Expose
    private Float elevation;
    @Expose
    private Integer level;
    @Expose
    private Location location;
    @Expose
    private String viewpoint;

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getElevation() {
        return elevation;
    }

    public void setElevation(Float elevation) {
        this.elevation = elevation;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getViewpoint() {
        return viewpoint;
    }

    public void setViewpoint(String viewpoint) {
        this.viewpoint = viewpoint;
    }

    public String toString(){
        return viewpoint;
    }

}
