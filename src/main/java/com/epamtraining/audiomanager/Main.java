package com.epamtraining.audiomanager;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.Disk;
import com.epamtraining.audiomanager.service.DiskService;
import com.epamtraining.audiomanager.service.Impl.DiskServiceImpl;
import com.epamtraining.audiomanager.service.Impl.FromFileDataReaderImpl;

import java.util.List;

public class Main {
    public static final String PATH_TO_FILE = "./src/main/resources/data.txt";

    public static void main(String[] args) {

        System.out.println("Start AudioManager");

        List<AudioTrack> audioTrackList = new FromFileDataReaderImpl().parceDataToAudioTrack(
                new FromFileDataReaderImpl().readFromFile(PATH_TO_FILE));

        for (AudioTrack track : audioTrackList) {
            System.out.println(track.toString());
        }

        Disk disk = new Disk("My collection", audioTrackList);
        System.out.println("Total length of all tracks: " + disk.getDiskDuration());

        DiskService diskService = new DiskServiceImpl();

        System.out.println(diskService.sortDisk(disk).toString());

        System.out.println(diskService.findByRange(3.8d,5d,disk).toString());
    }

}
