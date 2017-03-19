package org.olim.client.data;

import java.util.ArrayList;
import java.util.List;

public class CountryBox {
    private String counrty;
    private List<String> cities;

    public CountryBox(String counrty) {
        this.counrty = counrty;
        this.cities = new ArrayList<>();
    }

    public String getCounrty() {
        return counrty;
    }

    public void setCounrty(String counrty) {
        this.counrty = counrty;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public void add(String city) {
        this.cities.add(city);
    }

    public void add(int index, String city) {
        this.cities.add(index, city);
    }

    public void remove(String city) {
        this.cities.remove(city);
    }

    public void remove(int index) {
        this.cities.remove(index);
    }

}
