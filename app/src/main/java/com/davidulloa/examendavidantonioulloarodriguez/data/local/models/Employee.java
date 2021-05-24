package com.davidulloa.examendavidantonioulloarodriguez.data.local.models;


import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "employee",indices = {@Index("id"),@Index("location_id")}
        ,primaryKeys = {"id","location_id"})
public class Employee {

    @Ignore
    public Employee(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public Employee() {
    }

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("location")
    @Embedded(prefix = "location_")
    @NonNull
    private Location location;
    @SerializedName("mail")
    @Expose
    private String mail;

    public static class Location {

        public Location() {
        }

        @SerializedName("id")
        @Expose
        @NonNull
        private int id;

        @SerializedName("lat")
        @Expose
        private float lat;
        @SerializedName("log")
        @Expose
        private float log;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getLat() {
            return lat;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

        public float getLog() {
            return log;
        }

        public void setLog(float log) {
            this.log = log;
        }

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
