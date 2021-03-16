package com.epamtraining.audiomanager.model;

import java.util.Comparator;

public class AudioTrack extends AbstractTrack implements Comparator<AudioTrack> {
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
        return super.toString() + "Music style: " + musicStyle;
    }

    @Override
    public int compare(AudioTrack track1, AudioTrack track2) {
        return -track1.musicStyle.compareTo(track2.musicStyle); //this flips the order
        //return track1.getArtistName().toString().compareTo(track2.getArtistName().toString());
        //return track1.getDuration().compareTo(track2.getDuration());// this compares duration
    }
}
