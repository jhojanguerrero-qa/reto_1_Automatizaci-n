package com.co.choucair.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class TitleLombokData {
    private String titulo;

    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    public static List<TitleLombokData> convertToTitleData(DataTable table) {
        List<TitleLombokData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();


        for (Map<String, String> map : mapInfo) {
            data.add(OBJECTMAPPER.convertValue(map, TitleLombokData.class));
        }
        return data;
    }
}
