package com.epamtraining.audiomanager.service;


import com.epamtraining.audiomanager.model.AudioTrack;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FromFileDataReader {

    private final List<String> dataFromFile = new ArrayList<>();

    public List<String> read(String pathFile){
        BufferedReader reader = null;
        {
            try {
                String strCurrentLine;
                reader = new BufferedReader(new FileReader(pathFile));
                while ((strCurrentLine = reader.readLine()) != null) {
                    dataFromFile.add(strCurrentLine);
                }
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
}
