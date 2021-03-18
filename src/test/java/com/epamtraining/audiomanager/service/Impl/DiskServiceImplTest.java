package com.epamtraining.audiomanager.service.Impl;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.Disk;
import com.epamtraining.audiomanager.model.MusicStyles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class DiskServiceImplTest {

    private static List<AudioTrack> testListAudioTrack = new ArrayList<>();
    private static Disk testDisk;
    private DiskServiceImpl diskService = new DiskServiceImpl();

    @BeforeAll
    public static void init() {
        testListAudioTrack.add(new AudioTrack("artistName1", "testTrackName1", 1.0d, MusicStyles.POP));
        testListAudioTrack.add(new AudioTrack("artistName2", "testTrackName2", 2.0d, MusicStyles.POP));
        testListAudioTrack.add(new AudioTrack("artistName3", "testTrackName3", 2.0d, MusicStyles.POP));
        testDisk = new Disk("testDiskName", testListAudioTrack);
    }

    @Test
    public void testFindByRange(){
        Assertions.assertTrue(diskService.findByRange(0.0d,0.0d,testDisk).isEmpty());
    }

}