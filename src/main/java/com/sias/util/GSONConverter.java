/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Fernando Laranjo
 */
public class GSONConverter {

    private static Gson gson;

    private static Gson gsonWithHour;

    private static Gson getGSON() {
        if (gson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("dd/MM/yyyy");
            gson = gsonBuilder.create();
        }
        return gson;
    }

    private static Gson getGSONWithHour() {
        if (gsonWithHour == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("dd/MM/yyyy HH:mm:ss");
            gsonWithHour = gsonBuilder.create();
        }
        return gsonWithHour;
    }

    public static Object convert(String jsonData, Class clazz) {
        try {
            return getGSON().fromJson(jsonData, clazz);
        } catch (Exception e) {
            return getGSONWithHour().fromJson(jsonData, clazz);
        }
    }

}
