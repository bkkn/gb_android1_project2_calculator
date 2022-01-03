package me.bkkn.gb_android1_project2_calculator.model.states;

import java.util.List;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.model.Expression;

/**
 * Last state, wait for new expression input: sign - or num
 */
public class ResultState extends SignState {
    public ResultState(Expression expression) {
        super(expression);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        if (inputSymbol == InputSymbol.EQUALS)
            return this;
        expression.clear();
        switch (inputSymbol) {
            case OP_MINUS:
                expression.addInputSymbol(InputSymbol.OP_MINUS);
                return new FirstIntState(expression.getInputSymbols());
            case DOT:
                expression.addInputSymbol(InputSymbol.NUM_0);
                expression.addInputSymbol(InputSymbol.DOT);
                return new FloatState(expression.getInputSymbols());
            case NUM_0:
                expression.addInputSymbol(InputSymbol.NUM_0);
                return new ZeroState(expression.getInputSymbols());
            case NUM_1:
            case NUM_2:
            case NUM_3:
            case NUM_4:
            case NUM_5:
            case NUM_6:
            case NUM_7:
            case NUM_8:
            case NUM_9:
                expression.addInputSymbol(inputSymbol);
                return new IntState(expression);
            case CLEAR:
                return new SignState();
            case OP_PLUS:
            default:
                return this;
        }
    }
}
