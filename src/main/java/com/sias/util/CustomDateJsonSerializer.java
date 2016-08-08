/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando
 */
public class CustomDateJsonSerializer implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}");
    private static final Pattern DATE_TIME_PATTERN_WITH_SECONDS = Pattern.compile("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}");

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String asString = json.getAsString();
        try {
            if (DATE_PATTERN.matcher(asString).matches()) {
                return getDateFormat().parse(asString);
            } else if (DATE_TIME_PATTERN.matcher(asString).matches()) {
                return getDateTimeFormat().parse(asString);
            } else if (DATE_TIME_PATTERN_WITH_SECONDS.matcher(asString).matches()) {
                return getDateTimeFormatWithSeconds().parse(asString);
            } else {
                throw new JsonParseException("Could not parse to date: " + json);
            }
        } catch (java.text.ParseException ex) {
            Logger.getLogger(CustomDateJsonSerializer.class.getName()).log(Level.SEVERE, null, ex);
            throw new JsonParseException("Could not parse to date: " + json);
        }
    }

    private static DateFormat getDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat;
    }

    private static DateFormat getDateTimeFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return dateFormat;
    }

    private static DateFormat getDateTimeFormatWithSeconds() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat;
    }

    @Override
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        String dateFormatted;
        if (hours == 0 && minutes == 0 && seconds == 0) {
            dateFormatted = getDateFormat().format(date);
        } else {
            dateFormatted = getDateTimeFormat().format(date);
        }
        return new JsonPrimitive(dateFormatted);
    }

}
