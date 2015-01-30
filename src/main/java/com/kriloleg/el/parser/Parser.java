package com.kriloleg.el.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private static final String WORDS_SEPARATOR = "=";

    public Map<String, String> parse(List<String> lines){
        Map<String, String> wordsMap = new HashMap<String, String>();
        
        for(String line : lines) {
            wordsMap.put(parseKey(line), parseValue(line));
        }
        
        return wordsMap;
    }

    private String parseKey(String line) {
        return line.split(WORDS_SEPARATOR)[0].trim();
    }
    
    private String parseValue(String line) {
        return line.split(WORDS_SEPARATOR)[1].trim();
    }
}
