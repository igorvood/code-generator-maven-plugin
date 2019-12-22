package ru.vood.generator.read.dto.jav;

import java.util.List;

public class YamlDto {

    private List<KeyValDto> map;
    private List<KeyMapDto> multyMaps;


    public YamlDto() {
    }

    public YamlDto(List<KeyValDto> map, List<KeyMapDto> multyMaps) {
        this.map = map;
        this.multyMaps = multyMaps;
    }

    public List<KeyValDto> getMap() {
        return map;
    }

    public void setMap(List<KeyValDto> map) {
        this.map = map;
    }

    public List<KeyMapDto> getMultyMaps() {
        return multyMaps;
    }

    public void setMultyMaps(List<KeyMapDto> multyMaps) {
        this.multyMaps = multyMaps;
    }
}
