package com.epamtraining.audiomanager.model;

import java.util.List;

public class Disk {

    private String diskName;
    private Double diskDuration;
    private List<AudioTrack> records;

    public Disk() {
    }

    public Disk(String diskName) {
        this.diskName = diskName;
    }

    public Disk(String diskName, List<AudioTrack> records) {
        this.diskName = diskName;
        this.records = records;
        calculateDuration();
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

    public void addTrack(AudioTrack audioTrack) {
        this.records.add(audioTrack);
        calculateDuration();
    }

    private void calculateDuration() {
        this.diskDuration = 0.00d;
        for (AudioTrack track : this.records) {
            this.diskDuration += track.getDuration();
        }

    }

    @Override
    public String toString() {
        String string = "";
        for (AudioTrack track : getRecords()) {
            string += track + "\n";
        }

        return "Disk Name: " + getDiskName() + "\n" +
                "Total length of all tracks: " + getDiskDuration() + "\n" +
                "Tracks --------------->" + "\n" +
                string;
    }

}