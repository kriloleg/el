package com.kriloleg.englishlearning;

import java.io.Console;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.kriloleg.englishlearning.loader.Loader;
import com.kriloleg.englishlearning.parser.Parser;

public class Start {
    private Loader loader;
    private Parser parser;
    private Console console;
    
    public Start() {
        loader = new Loader();
        parser = new Parser();
        console = System.console();
    }
    
    public static void main(String[] args) {
        Start starter = new Start();
        Map<String, String> wordsMap = starter.loadWords(args[0]);
        starter.studyEnglish(wordsMap);
    }
    
    private void studyEnglish(Map<String, String> wordsMap) {
        for(Entry<String, String> entry : wordsMap.entrySet()) {
            String key = entry.getKey();
            
            console.printf("%s: ", key);
            String inputValue = console.readLine().trim();
            
            if (!wordsMap.containsValue(inputValue)) {
                console.printf("Wrong! Correct word is: %s \n", wordsMap.get(key));
            }
        }    
    }

    public Map<String, String> loadWords(String filename){
        List<String> lines = loader.load(filename);

        return parser.parse(lines);
    }
}
