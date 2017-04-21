package com.travelSite.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    private String name;
    private double longitude;
    private double latitude;
    private String country;

    public City() {
    }

    @JsonCreator
    public City(@JsonProperty("name")String name,
                @JsonProperty("country") String country,
                @JsonProperty("latitude") double latitude,
                @JsonProperty("longitude") double longitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (Double.compare(city.getLongitude(), getLongitude()) != 0) return false;
        if (Double.compare(city.getLatitude(), getLatitude()) != 0) return false;
        if (getName() != null ? !getName().equals(city.getName()) : city.getName() != null) return false;
        return getCountry() != null ? getCountry().equals(city.getCountry()) : city.getCountry() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        temp = Double.doubleToLongBits(getLongitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLatitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        return result;
    }
}
