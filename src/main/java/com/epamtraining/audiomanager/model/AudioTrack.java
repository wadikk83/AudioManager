package com.epamtraining.audiomanager.model;

public class AudioTrack extends AbstractTrack  {
    private final MusicStyles musicStyle;

    public AudioTrack(String artistName, String trackName, Double duration, MusicStyles musicStyle) {
        super(artistName, trackName, duration);
        this.musicStyle = musicStyle;
    }

    public MusicStyles getMusicStyle() {
        return musicStyle;
    }

    @Override
    public String toString() {
        return super.toString() + ", Music style: " + musicStyle;
    }

}
