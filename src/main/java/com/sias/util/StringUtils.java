/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.util;

/**
 *
 * @author Fernando
 */
public class StringUtils {

    public static String substringToQuery(String field) {

        if (field.length() > 63) {
            field = field.substring(0, 63);
        }

        return field;
    }

}
