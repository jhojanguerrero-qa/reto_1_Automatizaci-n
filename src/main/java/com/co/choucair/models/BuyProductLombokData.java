package com.co.choucair.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class BuyProductLombokData {

    private String primerNombre;
    private String apellido;
    private String codigoPostal;

    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    public static List<BuyProductLombokData> convertToBuyProduct(DataTable table) {
        List<BuyProductLombokData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();


        for (Map<String, String> map : mapInfo) {
            data.add(OBJECTMAPPER.convertValue(map, BuyProductLombokData.class));
        }
        return data;
    }
}
