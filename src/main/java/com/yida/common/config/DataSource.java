package com.yida.common.config;


import java.util.HashMap;
import java.util.Map;

public class DataSource {

    public static Map<String, HashMap> getData() {
        Map<String, HashMap> hashMap = new HashMap<>(4);

        HashMap<String, Object> details = new HashMap<>(4);
        details.put("password", "admin");
        details.put("role", "admin");
        details.put("permission", "edit");

        hashMap.put("admin", details);
        return hashMap;
    }

}
