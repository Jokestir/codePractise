package com.example.android.quakereport;

import java.util.Date;

public class EarthquakeEvent {

    private String cityLoc;
    private double magnitude;
    private long timeInMilliseconds;
    private String websiteUrl;

    public EarthquakeEvent(String cityLoc, double magnitude, long timeInMilliseconds, String websiteUrl) {
        this.cityLoc = cityLoc;
        this.magnitude = magnitude;
        this.timeInMilliseconds = timeInMilliseconds;
        this.websiteUrl = websiteUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCityLoc() {
        return cityLoc;
    }

    public void setCityLoc(String cityLoc) {
        this.cityLoc = cityLoc;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    public void setDate(long timeInMilliseconds) {
        this.timeInMilliseconds = timeInMilliseconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EarthquakeEvent that = (EarthquakeEvent) o;

        if (Double.compare(that.magnitude, magnitude) != 0) return false;
        if (timeInMilliseconds != that.timeInMilliseconds) return false;
        return cityLoc != null ? cityLoc.equals(that.cityLoc) : that.cityLoc == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cityLoc != null ? cityLoc.hashCode() : 0;
        temp = Double.doubleToLongBits(magnitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (timeInMilliseconds ^ (timeInMilliseconds >>> 32));
        return result;
    }
}
