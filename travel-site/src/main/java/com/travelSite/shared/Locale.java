package com.travelSite.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Locale {
    private String local;

    public Locale() {
    }


    @JsonCreator
    public Locale(@JsonProperty("local")String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locale locale = (Locale) o;

        return getLocal() != null ? getLocal().equals(locale.getLocal()) : locale.getLocal() == null;
    }

    @Override
    public int hashCode() {
        return getLocal() != null ? getLocal().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Locale{" +
                "local='" + local + '\'' +
                '}';
    }
}
