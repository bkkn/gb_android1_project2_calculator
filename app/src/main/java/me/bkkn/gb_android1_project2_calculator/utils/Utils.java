package me.bkkn.gb_android1_project2_calculator.utils;

import android.content.Context;

import java.util.List;

import me.bkkn.gb_android1_project2_calculator.R;
import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;

public class Utils {
    static Context context = null;

    public static InputSymbol buttonToInputSymbol(int buttonId) {
        switch (buttonId) {

            case R.id.plus_button:
                return InputSymbol.OP_PLUS;
            case R.id.minus_button:
                return InputSymbol.OP_MINUS;
            case R.id.multiply_button:
                return InputSymbol.OP_MULTIPLY;
            case R.id.divide_button:
                return InputSymbol.OP_DIVIDE;

            case R.id.digit_one_button:
                return InputSymbol.NUM_1;
            case R.id.digit_two_button:
                return InputSymbol.NUM_2;
            case R.id.digit_three_button:
                return InputSymbol.NUM_3;
            case R.id.digit_four_button:
                return InputSymbol.NUM_4;
            case R.id.digit_five_button:
                return InputSymbol.NUM_5;
            case R.id.digit_six_button:
                return InputSymbol.NUM_6;
            case R.id.digit_seven_button:
                return InputSymbol.NUM_7;
            case R.id.digit_eight_button:
                return InputSymbol.NUM_8;
            case R.id.digit_nine_button:
                return InputSymbol.NUM_9;
            case R.id.digit_zero_button:
                return InputSymbol.NUM_0;

            case R.id.dot_button:
                return InputSymbol.DOT;
            case R.id.clear_button:
                return InputSymbol.CLEAR;
            case R.id.backspace_button:
                return InputSymbol.BACK;
            case R.id.equals_button:
                return InputSymbol.EQUALS;
            case R.id.lookup_button:
                return InputSymbol.LOOKUP;
            default:
                throw new IllegalStateException();
        }
    }

    public static String convertInputSymbolsToString(List<InputSymbol> inputSymbolList) {
        if (context == null)
            throw new NullPointerException();
        final StringBuilder sb = new StringBuilder();
        for (InputSymbol inputSymbol : inputSymbolList) {
            switch (inputSymbol) {
                case NUM_0:
                    sb.append(context.getResources().getString(R.string.digit_zero_label_0));
                    break; // todo вынести в strings.xml
                case NUM_1:
                    sb.append(context.getResources().getString(R.string.digit_one_label_1));
                    break;
                case NUM_2:
                    sb.append(context.getResources().getString(R.string.digit_two_label_2));
                    break;
                case NUM_3:
                    sb.append(context.getResources().getString(R.string.digit_three_label_3));
                    break;
                case NUM_4:
                    sb.append(context.getResources().getString(R.string.digit_four_label_4));
                    break;
                case NUM_5:
                    sb.append(context.getResources().getString(R.string.digit_five_label_5));
                    break;
                case NUM_6:
                    sb.append(context.getResources().getString(R.string.digit_six_label_6));
                    break;
                case NUM_7:
                    sb.append(context.getResources().getString(R.string.digit_seven_label_7));
                    break;
                case NUM_8:
                    sb.append(context.getResources().getString(R.string.digit_eight_label_8));
                    break;
                case NUM_9:
                    sb.append(context.getResources().getString(R.string.digit_nine_label_9));
                    break;
                case DOT:
                    sb.append(context.getResources().getString(R.string.point_button_label));
                    break;
                case OP_MINUS:
                    sb.append(context.getResources().getString(R.string.operation_minus_label));
                    break;
                case OP_PLUS:
                    sb.append(context.getResources().getString(R.string.operation_plus_label));
                    break;
                case OP_MULTIPLY:
                    sb.append(context.getResources().getString(R.string.operation_multiply_label));
                    break;
                case OP_DIVIDE:
                    sb.append(context.getResources().getString(R.string.operation_divide_label));
                    break;
                case EQUALS:
                    sb.append(context.getResources().getString(R.string.equals_button_label));
                    break;
                default:
                    sb.append("@");
                    break;
            }
        }
        return sb.toString();
    }

    public static void setContext(Context context) {
        Utils.context = context;
    }
}
