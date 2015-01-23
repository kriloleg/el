package com.kriloleg.englishlearning.loader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.kriloleg.englishlearning.exceptions.FileNotFoundException;

public class Loader {
    
    private static final String CHARACTER = "utf-8";

    public List<String> load(String filename){
        Path path = Paths.get(filename);
        List<String> stringedFile;
        
        try {
            stringedFile = Files.readAllLines(path, Charset.forName(CHARACTER));
        } catch (IOException e) {
            throw new FileNotFoundException("File not found!");
        }
        return stringedFile;        
    }
}
