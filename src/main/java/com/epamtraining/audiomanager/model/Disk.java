package com.epamtraining.audiomanager.model;

import java.util.List;

public class Disk {

    private String diskName;
    private Double diskDuration;
    private List<AudioTrack> records;

    public Disk(String diskName) {
        this.diskName = diskName;
    }

    public Disk(String diskName, List<AudioTrack> records) {
        this.diskName = diskName;
        this.records = records;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public Double getDiskDuration() {
        return diskDuration;
    }

    public List<AudioTrack> getRecords() {
        return records;
    }

    public void setRecords(List<AudioTrack> records) {
        this.records = records;
    }

    public void addTrack(AudioTrack audioTrack){

    };


}
