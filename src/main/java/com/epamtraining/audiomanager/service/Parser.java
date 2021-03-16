package com.epamtraining.audiomanager.service;

import com.epamtraining.audiomanager.model.AudioTrack;

import java.util.List;

public interface Parser {

    List<AudioTrack> parceData(List<String> inputList);
}
