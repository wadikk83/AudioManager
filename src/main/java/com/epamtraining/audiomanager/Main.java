package com.epamtraining.audiomanager;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.Disk;
import com.epamtraining.audiomanager.service.DiskService;
import com.epamtraining.audiomanager.service.Impl.DiskServiceImpl;
import com.epamtraining.audiomanager.service.Impl.FromFileDataReaderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static final String PATH_TO_FILE = "./src/main/resources/data.txt";
    public static final Double FROM = 3.8d;
    public static final Double TO = 5d;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("Start AudioManager");

        LOGGER.info("Application Audiomanager is started at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));


        List<AudioTrack> audioTrackList = new FromFileDataReaderImpl().parceDataToAudioTrack(
                new FromFileDataReaderImpl().readFromFile(PATH_TO_FILE));

        System.out.println("Track list----------------------->");
        for (AudioTrack track : audioTrackList) {
            System.out.println(track.toString());
        }
        System.out.println("========================================================================");

        Disk disk = new Disk("My collection", audioTrackList);
        System.out.println("Total length of all tracks: " + disk.getDiskDuration());

        DiskService diskService = new DiskServiceImpl();

        System.out.println("Track list after sorting----------------------->");
        System.out.println(diskService.sortDisk(disk).toString());

        System.out.println("A list of tracks whose length is between "+FROM+" min. and "+TO+" min. ------------------>");
        System.out.println(diskService.findByRange(FROM, TO, disk).toString());

        LOGGER.info("Application Audiomanager is finished at " +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        LOGGER.info("==========================================================================");
    }

}
