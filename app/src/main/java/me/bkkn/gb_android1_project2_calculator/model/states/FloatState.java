package me.bkkn.gb_android1_project2_calculator.model.states;

import java.util.List;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;

public class FloatState extends BaseState {

    public FloatState(List<InputSymbol> input) {
        this.expression.addInputSymbols(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case OP_MINUS:
                expression.addInputSymbol(InputSymbol.OP_MINUS);
                return this;
            case OP_PLUS:
                expression.addInputSymbol(InputSymbol.OP_PLUS);
                return this;
            case OP_MULTIPLY:
                expression.addInputSymbol(InputSymbol.OP_MULTIPLY);
                return this;
            case OP_DIVIDE:
                expression.addInputSymbol(InputSymbol.OP_DIVIDE);
                return this;
            case NUM_0:
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
                return this;
            case CLEAR:
                return new SignState();
            case BACK:
                expression.backspace();
                if(expression.hasDot())
                    return this;
                else
                    return new IntState(expression);
            case EQUALS:
                expression.evaluate();
                expression.addInputSymbol(InputSymbol.EQUALS);
                return new ResultState(expression);
            default:
                return this;
        }
    }
}
