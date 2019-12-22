package ru.vood.generator.read.dto.jav;

public class KeyValDto {
    private String key;
    private String val;

    public KeyValDto() {
    }

    public KeyValDto(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
