/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;

/**
 *
 * @author Fernando Laranjo
 */
public class GSONConverter {

    private static Gson gson;

    private static Gson getGSON() {
        if (gson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new CustomDateJsonSerializer());
            gson = gsonBuilder.create();
        }
        return gson;
    }

    public static Object convert(String jsonData, Class clazz) {
        return getGSON().fromJson(jsonData, clazz);
    }

}
