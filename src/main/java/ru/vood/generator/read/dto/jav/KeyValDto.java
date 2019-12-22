package ru.vood.generator.read.dto.jav;

public class KeyValDto<T> {
    private String key;
    private T val;

    public KeyValDto() {
    }

    public KeyValDto(String key, T val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}
