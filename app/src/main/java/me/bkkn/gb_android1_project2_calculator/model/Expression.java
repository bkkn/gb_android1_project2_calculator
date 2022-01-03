package me.bkkn.gb_android1_project2_calculator.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.utils.Utils;

public class Expression implements Parcelable {
    public static final String KEY = "expression";
    //private String expression;
    private List<InputSymbol> inputSymbols = new ArrayList<>();

    public Expression(Expression expression) {
        this.inputSymbols = expression.inputSymbols;
    }

    public List<InputSymbol> getInputSymbols() {
        return inputSymbols;
    }

    public void addInputSymbols(List<InputSymbol> list) {
        this.inputSymbols.addAll(list);
    }

    public void setInputSymbols(List<InputSymbol> inputSymbols) {
        this.inputSymbols = inputSymbols;
    }

    public Expression() {

    }

    public Expression(Parcel in) {
    }

    public static final Creator<Expression> CREATOR = new Creator<Expression>() {
        @Override
        public Expression createFromParcel(Parcel in) {
            return new Expression(in);
        }

        @Override
        public Expression[] newArray(int size) {
            return new Expression[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
    
    public void clear() {
        this.inputSymbols.clear();
    }

    @Override
    public String toString() {
        return Utils.convertInputSymbolsToString(this.inputSymbols);
    }

    public void addInputSymbol(InputSymbol inputSymbol) {
        this.inputSymbols.add(inputSymbol);
    }

    public double evaluate() {
        return 0;
    }
    public boolean resultIsInteger()
    {
        double result = evaluate();
        return (result % 1) == 0;
    }
}
