package com.kriloleg.el.config;

import java.io.IOException;
import java.util.Properties;

import com.kriloleg.el.exceptions.FileNotFoundException;

public class Configurations {
    private static Configurations CONFIGURATIONS;
    private static String CONFIG_FILE = "config.properties";
    private Properties properties;
    
    private Configurations() {}
    
    public static Configurations getInstance(){
        if (CONFIGURATIONS == null) {
            CONFIGURATIONS = new Configurations();
        }
        return CONFIGURATIONS;
    }
    
    public Properties getConfigs(){
        if(properties == null){
            properties = new Properties();
            try {
                properties.load(this.getClass().getResourceAsStream(CONFIG_FILE));
            } catch (IOException e) {
                throw new FileNotFoundException("Configuration file wasn't found!");
            }
        }
        return properties;
    }
}
