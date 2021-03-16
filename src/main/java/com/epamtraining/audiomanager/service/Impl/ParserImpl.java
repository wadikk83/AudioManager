package com.epamtraining.audiomanager.service.Impl;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.MusicStyles;
import com.epamtraining.audiomanager.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserImpl implements Parser {

    @Override
    public List<AudioTrack> parceData(List<String> inputList) {

        List<AudioTrack> outputList = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\|");
        for (String text : inputList) {
            String[] strings = pattern.split(text);
            if (strings != null) {
                try {
                AudioTrack track = new AudioTrack(strings[0], strings[1], Double.parseDouble(strings[2]), MusicStyles.valueOf(strings[3]));
                outputList.add(track);}
                catch (IllegalArgumentException e) {
                    System.out.println("Oop's, parsing is not ok");
                    System.out.println(text);
                    //e.printStackTrace();
                }
            }
        }
        return outputList;
    }
}
