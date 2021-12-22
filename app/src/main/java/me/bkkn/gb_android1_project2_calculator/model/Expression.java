package me.bkkn.gb_android1_project2_calculator.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Expression implements Serializable {
    public static final String KEY = "expression";
    private String expression;

    public Expression(CharSequence text) {
        expression = (String) text;
    }

    @NonNull
    @Override
    public String toString() {
        return expression;
    }
}
