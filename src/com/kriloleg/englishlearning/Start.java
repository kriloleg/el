package com.kriloleg.englishlearning;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.kriloleg.englishlearning.loader.Loader;
import com.kriloleg.englishlearning.parser.Parser;

public class Start {
    private Loader loader;
    private Parser parser;
    private PrintStream out;
    private InputStream in;
    private Scanner scanner;
    
    public Start() {
        loader = new Loader();
        parser = new Parser();
        out = System.out; 
    }
    
    public static void main(String[] args) {
        Start starter = new Start();
        Map<String, String> wordsMap = starter.loadWords(args[0]);
        starter.studyEnglish(wordsMap);
    }
    
    private void studyEnglish(Map<String, String> wordsMap) {
        scanner = new Scanner(System.in);
        for(Entry<String, String> entry : wordsMap.entrySet()) {
            out.println(entry.getKey());
            String line = scanner.nextLine().trim();
            
            if (!wordsMap.containsValue(line)) {
                out.println("Your word isn't correct!");
            }
        }    
    }
    
    public Map<String, String> loadWords(String filename){
        List<String> lines = loader.load(filename);

        return parser.parse(lines);
    }
    
    private void printOnScreen(Map<String, String> wordsMap){
        for(Entry<String, String> entry : wordsMap.entrySet()) {
            out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
