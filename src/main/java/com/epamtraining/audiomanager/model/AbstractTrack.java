package com.epamtraining.audiomanager.model;

import java.util.UUID;

public abstract class AbstractTrack {
    private final UUID uuid;
    private final String artistName;
    private final String trackName;
    private final Double duration;

    public AbstractTrack(String artistName, String trackName, Double duration) {
        this.uuid = UUID.randomUUID();
        this.artistName = artistName;
        this.trackName = trackName;
        this.duration = duration;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public Double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return  "Artist Name: " + getArtistName() +
                ", Track name: " + getTrackName() +
                ", Duration: " + getDuration();
    }
}
