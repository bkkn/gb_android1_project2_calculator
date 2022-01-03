package me.bkkn.gb_android1_project2_calculator.model.states;

import java.util.List;
import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;

/**
 * Ввод первой цифры целой части числа после после знака (минус/плюс)
 * -"2"2323.23424
 */
public class FirstIntState extends BaseState {

    public FirstIntState(List<InputSymbol> input) {
        this.expression.addInputSymbols(expression.getInputSymbols());
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case NUM_1:
            case NUM_2:
            case NUM_3:
                expression.addInputSymbol(inputSymbol);
                return new IntState(expression.getInputSymbols());
            case DOT:
                expression.addInputSymbol(InputSymbol.NUM_0);
                expression.addInputSymbol(InputSymbol.DOT);
                return new FloatState(expression.getInputSymbols());
            case NUM_0:
                expression.addInputSymbol(InputSymbol.NUM_0);
                return new ZeroState(expression.getInputSymbols());
            case CLEAR:
                return new SignState();
            default:
                return this;
        }
    }
}
