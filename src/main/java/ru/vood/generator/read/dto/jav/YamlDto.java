package ru.vood.generator.read.dto.jav;

import java.util.List;

public class YamlDto {

    private List<KeyValDto<String>> map;
    private List<KeyValDto<List<KeyValDto<String>>>> multiMaps;


    public YamlDto() {
    }

    public YamlDto(List<KeyValDto<String>> map, List<KeyValDto<List<KeyValDto<String>>>> multiMaps) {
        this.map = map;
        this.multiMaps = multiMaps;
    }

    public List<KeyValDto<String>> getMap() {
        return map;
    }

    public void setMap(List<KeyValDto<String>> map) {
        this.map = map;
    }

    public List<KeyValDto<List<KeyValDto<String>>>> getMultiMaps() {
        return multiMaps;
    }

    public void setMultiMaps(List<KeyValDto<List<KeyValDto<String>>>> multiMaps) {
        this.multiMaps = multiMaps;
    }
}
