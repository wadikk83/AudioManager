package com.epamtraining.audiomanager.service.Impl;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.MusicStyles;
import com.epamtraining.audiomanager.service.FromFileDataReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FromFileDataReaderImpl implements FromFileDataReader {

    private final List<String> dataFromFile = new ArrayList<>();

    @Override
    public List<String> readFromFile(String pathFile) {

        BufferedReader reader = null;
        {
            try {
                String strCurrentLine;
                reader = new BufferedReader(new FileReader(pathFile));
                while ((strCurrentLine = reader.readLine()) != null) {
                    dataFromFile.add(strCurrentLine);
                }
            } catch (FileNotFoundException exception){
                System.out.println("File not found");

            } catch (IOException e) {
                System.out.println("Oop's");
                e.printStackTrace();
            } finally {

                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return dataFromFile;
    }


    @Override
    public List<AudioTrack> parceDataToAudioTrack(List<String> inputList) {

        List<AudioTrack> outputList = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\|");
        for (String text : inputList) {
            String[] strings = pattern.split(text);
            if (strings != null) {
                try {
                    AudioTrack track = new AudioTrack(strings[0], strings[1], Double.parseDouble(strings[2]), MusicStyles.valueOf(strings[3]));
                    outputList.add(track);
                } catch (IllegalArgumentException e) {
                    System.out.println("Oop's, parsing is not ok");
                    System.out.println(text);
                    //e.printStackTrace();
                }
            }
        }
        return outputList;
    }

}
