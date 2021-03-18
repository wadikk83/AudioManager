package com.epamtraining.audiomanager.service;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.Disk;

import java.util.List;

public interface DiskService {


    List<AudioTrack> findByRange(Double from, Double to, Disk disk);

    Disk sortDisk(Disk disk);
}
