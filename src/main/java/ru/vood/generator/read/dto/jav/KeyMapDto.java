package ru.vood.generator.read.dto.jav;

import java.util.List;

public class KeyMapDto {

    private String key;
    private List<KeyValDto> val;

    public KeyMapDto() {
    }

    public KeyMapDto(String key, List<KeyValDto> val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<KeyValDto> getVal() {
        return val;
    }

    public void setVal(List<KeyValDto> val) {
        this.val = val;
    }
}
