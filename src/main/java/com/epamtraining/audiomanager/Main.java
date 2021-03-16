package com.epamtraining.audiomanager;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.service.FromFileDataReader;
import com.epamtraining.audiomanager.service.Impl.ParserImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String PATH_TO_FILE = "./src/main/resources/data.txt";

    public static void main(String[] args) {

        System.out.println("Start");

        List<String> temp = new FromFileDataReader().read(PATH_TO_FILE);

        for (String string : temp) {
            System.out.println(string);
        }

        List<AudioTrack> list1 = new ParserImpl().parceData(temp);

        for (AudioTrack track : list1) {
            System.out.println(track);
        }


    }

}
