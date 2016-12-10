package com.geography.localize.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class Southwest {

    private Double lat;
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Southwest{" + "lat=" + lat + ", lng=" + lng + '}';
    }

}
