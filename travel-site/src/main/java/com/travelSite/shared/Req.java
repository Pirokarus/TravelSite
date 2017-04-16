package com.travelSite.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Req {
    public String local;

    public Req() {
    }


    @JsonCreator
    public Req(@JsonProperty("local")String local) {
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

        Req req = (Req) o;

        return getLocal() != null ? getLocal().equals(req.getLocal()) : req.getLocal() == null;
    }

    @Override
    public int hashCode() {
        return getLocal() != null ? getLocal().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Req{" +
                "local='" + local + '\'' +
                '}';
    }
}
