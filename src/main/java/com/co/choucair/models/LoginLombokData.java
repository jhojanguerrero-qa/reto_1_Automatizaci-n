package com.co.choucair.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class LoginLombokData {

    private String usuario;
    private String contraseña;

    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    public static List<LoginLombokData> convertToLoginData(DataTable table) {
        List<LoginLombokData> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = table.asMaps();


        for (Map<String, String> map : mapInfo) {
            data.add(OBJECTMAPPER.convertValue(map, LoginLombokData.class));
        }
        return data;
    }


}
