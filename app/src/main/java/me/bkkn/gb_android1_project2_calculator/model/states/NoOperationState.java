package me.bkkn.gb_android1_project2_calculator.model.states;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.model.Expression;

public class NoOperationState extends BaseState {

    public NoOperationState(Expression expression) {
        this.expression.addInputSymbols(expression.getInputSymbols());
        this.expression.setResult(expression.getResult());
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
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
                return new IntState(expression);
            case DOT:
                expression.addInputSymbol(InputSymbol.NUM_0);
                expression.addInputSymbol(InputSymbol.DOT);
                return new FloatState(expression.getInputSymbols());
            case CLEAR:
                return new SignState();
            case BACK:
                expression.backspace();
                return new SignState(expression);
            default:
                return this;
        }
    }
}
