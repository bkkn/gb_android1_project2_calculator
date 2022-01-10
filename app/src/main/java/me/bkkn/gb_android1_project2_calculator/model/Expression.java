package me.bkkn.gb_android1_project2_calculator.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.utils.Utils;

public class Expression implements Parcelable {
    public static final String KEY = "expression";
    public static final double RESULT_DEFAULT = Double.MAX_VALUE;
    private double result = RESULT_DEFAULT;
    private List<InputSymbol> inputSymbols = new ArrayList<>();

    public Expression(Expression expression) {
        this.inputSymbols = expression.inputSymbols;
        this.result = expression.result;
    }

    public Expression() {
    }

    public boolean hasDot() {
        return inputSymbols.contains(InputSymbol.DOT);
    }

    protected Expression(Parcel in) {
        inputSymbols = in.readArrayList(Expression.class.getClassLoader());
        result = in.readDouble();
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

    public List<InputSymbol> getInputSymbols() {
        return inputSymbols;
    }

    public void addInputSymbols(List<InputSymbol> list) {
        this.inputSymbols.addAll(list);
    }

    public void setInputSymbols(List<InputSymbol> inputSymbols) {
        this.inputSymbols = inputSymbols;
    }

    public double evaluate() {
        try {
            String s = toString();
            result = Double.parseDouble(Solver.solve(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        return Utils.convertInputSymbolsToString(this.inputSymbols);
    }

    public void addInputSymbol(InputSymbol inputSymbol) {
        this.inputSymbols.add(inputSymbol);
    }

    public boolean resultIsCalculated() {
        //return (result - Double.MAX_VALUE) >= 1e-5;
        return result != Double.MAX_VALUE;// is it ok to compare like this?
    }

    public boolean resultIsInteger() {
        if (!resultIsCalculated())
            result = evaluate();
        return (result % 1) == 0;
    }

    public String getResultString() {
        if (resultIsInteger())
            return String.valueOf((int) result);
        else
            //return String.format("%.3f", result);
            return String.valueOf(result);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(inputSymbols);
        dest.writeDouble(result);
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void backspace() {
        if (!inputSymbols.isEmpty())
            inputSymbols.remove(inputSymbols.size() - 1);
    }

    public void clear() {
        this.inputSymbols.clear();
        this.result = RESULT_DEFAULT;
    }

    public double getResult() {
        return result;
    }
}
