package com.co.choucair.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ShippingInformationLombokData {

    private String primerNombre;
    private String apellido;
    private String codigoPostal;

    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    public static List<ShippingInformationLombokData> convertToShippingInformation(DataTable table) {
        List<ShippingInformationLombokData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();


        for (Map<String, String> map : mapInfo) {
            data.add(OBJECTMAPPER.convertValue(map, ShippingInformationLombokData.class));
        }
        return data;
    }
}
