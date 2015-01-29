package com.kriloleg.englishlearning.dto;

public class Word {
    private String value;
    private String transcryption;
    private String[] translates;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getTranscryption() {
        return transcryption;
    }
    public void setTranscryption(String transcryption) {
        this.transcryption = transcryption;
    }
    public String[] getTranslates() {
        return translates;
    }
    public void setTranslates(String[] translates) {
        this.translates = translates;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Word other = (Word) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
