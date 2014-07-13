package com.tatadada.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by mbogheti on 13/07/14.
 */
@Entity
public class Channel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String subtitle;
    private String streamurl;
    private String resource;

    protected Channel() {
    }

    public Channel(String title, String subtitle, String streamurl, String resource) {
        this.title = title;
        this.subtitle = subtitle;
        this.streamurl = streamurl;
        this.resource = resource;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getStreamurl() {
        return streamurl;
    }

    public void setStreamurl(String streamurl) {
        this.streamurl = streamurl;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Channel)) return false;

        Channel channel = (Channel) o;

        if (id != channel.id) return false;
        if (!resource.equals(channel.resource)) return false;
        if (!streamurl.equals(channel.streamurl)) return false;
        if (!subtitle.equals(channel.subtitle)) return false;
        if (!title.equals(channel.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + subtitle.hashCode();
        result = 31 * result + streamurl.hashCode();
        result = 31 * result + resource.hashCode();
        return result;
    }
}