package com.epamtraining.audiomanager.service.Impl;

import com.epamtraining.audiomanager.model.AudioTrack;
import com.epamtraining.audiomanager.model.MusicStyles;
import com.epamtraining.audiomanager.service.FromFileDataReader;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
public class FromFileDataReaderImpl implements FromFileDataReader {

    private final List<String> dataFromFile = new ArrayList<>();
    //private static final Logger LOGGER = LoggerFactory.getLogger(FromFileDataReaderImpl.class);

    @Override
    public List<String> readFromFile(String pathFile) {

        log.trace("Trying to read a file at the path " + pathFile);

        BufferedReader reader = null;
        {
            try {
                String strCurrentLine;
                reader = new BufferedReader(new FileReader(pathFile));
                while ((strCurrentLine = reader.readLine()) != null) {
                    dataFromFile.add(strCurrentLine);
                }
            } catch (FileNotFoundException exception) {
                System.out.println("File not found");
                log.warn("File not found ее the path " + pathFile);

            } catch (IOException e) {
                //System.out.println("Oop's");
                //e.printStackTrace();
                log.error("Opps, IOException" + e);
            } finally {

                try {
                    if (reader != null)
                        reader.close();
                    log.trace("File reading finished");
                } catch (IOException ex) {
                    log.error("Opps, IOException" + ex);
                }
            }
        }
        return dataFromFile;
    }


    @Override
    public List<AudioTrack> parceDataToAudioTrack(List<String> inputList) {

        List<AudioTrack> outputList = new ArrayList<>();

        log.trace("Trying parse data to List<AudioTrack>");

        Pattern pattern = Pattern.compile("\\|");
        for (String text : inputList) {
            String[] strings = pattern.split(text);
            if (strings != null) {
                try {
                    AudioTrack track = new AudioTrack(strings[0], strings[1], Double.parseDouble(strings[2]), MusicStyles.valueOf(strings[3]));
                    outputList.add(track);
                } catch (IllegalArgumentException e) {
                    /*System.out.println("Oop's, parsing is not ok");
                    System.out.println(text);*/
                    //e.printStackTrace();
                    log.warn("Attempt to parse the entry failed " + e);
                }
            }
        }
        log.trace("Data analysis completed");
        return outputList;
    }

}
