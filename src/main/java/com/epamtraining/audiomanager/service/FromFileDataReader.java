package com.epamtraining.audiomanager.service;

import com.epamtraining.audiomanager.model.AudioTrack;

import java.util.List;

public interface FromFileDataReader {

    List<AudioTrack> parceDataToAudioTrack(List<String> inputList);

    List<String> readFromFile(String pathFile);
}
