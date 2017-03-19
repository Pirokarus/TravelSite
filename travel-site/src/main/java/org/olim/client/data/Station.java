package org.olim.client.data;

import java.util.Date;

public class Station {
    private String station;
    private Date inDate;
    private Date outDate;

    public Station(String station, Date inDate, Date outDate) {
        this.station = station;
        this.inDate = inDate;
        this.outDate = outDate;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }
}
