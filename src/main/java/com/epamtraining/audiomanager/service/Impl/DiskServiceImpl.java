package com.epamtraining.audiomanager.service.Impl;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.Disk;
import com.epamtraining.audiomanager.service.DiskService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiskServiceImpl implements DiskService {

    @Override
    public List<AudioTrack> findByRange(Double from, Double to, Disk disk) {
        List<AudioTrack> listFromTo = new ArrayList<>();

        for (AudioTrack track : disk.getRecords()) {
            if (track.getDuration() >= from && track.getDuration() <= to) {
                listFromTo.add(track);
            }
        }
        return listFromTo;
    }

    @Override
    public Disk sortDisk(Disk disk) {
        Collections.sort(disk.getRecords(), new Comparator<AudioTrack>() {

            @Override
            public int compare(AudioTrack track1, AudioTrack track2) {
                //compare by field MusicStyle
                int compareRes = track1.getMusicStyle().compareTo(track2.getMusicStyle());
                if (compareRes !=0) return compareRes;

                //if music style is identical, compare by field artistName
                compareRes = track1.getArtistName().compareTo(track2.getArtistName());
                if (compareRes !=0) return compareRes;

                //if field artistName is identical, then compare by duration
                return track1.getDuration().compareTo(track2.getDuration());
            }
        });
        return disk;
    }
}
