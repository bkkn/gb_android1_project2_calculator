package me.bkkn.gb_android1_project2_calculator.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Expression implements Parcelable {
    public static final String KEY = "expression";
    private String expression;
    private String result = "not calculated";

    public Expression(CharSequence text) {
        expression = (String) text;
    }

    protected Expression(Parcel in) {
        expression = in.readString();
    }

    public String evaluate() {
        try {
            result = stringFromJNI(expression);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * A native method that is implemented by the 'gb_android1_project2_calculator' native library,
     * which is packaged with this application.
     *
     * @param s
     */
    public native String stringFromJNI(String s);

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(expression);
    }

    @Override
    public int describeContents() {
        return 0;
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

    @NonNull
    @Override
    public String toString() {
        return expression;
    }

    public String getResultString() {
        return result;
    }
}
