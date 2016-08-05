/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.util;

/**
 *
 * @author Fernando Laranjo
 */
public class Criteria {

    public static final String EQUALS = "=";

    public static final String ILIKE = "ILIKE";

    public static final String BIGGER_THEN = ">";

    public static final String BIGGER_OR_EQUALS_THEN = ">=";

    public static final String LESS_THEN = ">";

    public static final String LESS_OR_EQUALS_THEN = ">";

    private String attribute;

    private String operation;

    private Object value;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
