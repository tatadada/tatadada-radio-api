package com.tatadada.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by mbogheti on 13/09/14.
 */
@Entity(name = "stats")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String deviceId;
    String resource;
    Date requestDate;
    String useragent;

    public Statistic(String deviceId, String resource, Date requestDate, String useragent) {
        this.deviceId = deviceId;
        this.resource = resource;
        this.requestDate = requestDate;
        this.useragent = useragent;
    }

    public Statistic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistic)) return false;

        Statistic that = (Statistic) o;

        if (!deviceId.equals(that.deviceId)) return false;
        if (!id.equals(that.id)) return false;
        if (!requestDate.equals(that.requestDate)) return false;
        if (!resource.equals(that.resource)) return false;
        if (!useragent.equals(that.useragent)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + deviceId.hashCode();
        result = 31 * result + resource.hashCode();
        result = 31 * result + requestDate.hashCode();
        result = 31 * result + useragent.hashCode();
        return result;
    }
}
