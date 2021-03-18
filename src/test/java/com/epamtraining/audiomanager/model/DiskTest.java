package com.epamtraining.audiomanager.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class DiskTest {

    private static List<AudioTrack> testListAudioTrack = new ArrayList<>();
    private static Disk testDisk;

    @BeforeAll
    public static void init() {
        testListAudioTrack.add(new AudioTrack("artistName1", "testTrackName1", 1.0d, MusicStyles.POP));
        testListAudioTrack.add(new AudioTrack("artistName2", "testTrackName2", 2.0d, MusicStyles.POP));
        testListAudioTrack.add(new AudioTrack("artistName3", "testTrackName3", 2.0d, MusicStyles.POP));
        testDisk = new Disk("testDiskName", testListAudioTrack);
    }

    @Test
    public void testDiskDuration() {
        Double testDuration = 0d;

        for (AudioTrack track : testListAudioTrack) {
            testDuration += track.getDuration();
        }
        Assertions.assertEquals(5.0d, testDuration.doubleValue());
    }

    @Test
    public void testAddTrackToDisk() {
        testDisk.addTrack(new AudioTrack("artistName4", "testTrackName4", 2d, MusicStyles.POP));
        Assertions.assertEquals(4,testDisk.getRecords().size());
    }

}