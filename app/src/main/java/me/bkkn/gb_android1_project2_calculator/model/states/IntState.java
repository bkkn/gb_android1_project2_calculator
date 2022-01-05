package me.bkkn.gb_android1_project2_calculator.model.states;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.model.Expression;

public class IntState extends BaseState {

    public IntState(Expression expression) {
        this.expression.addInputSymbols(expression.getInputSymbols());
        this.expression.setResult(expression.getResult());
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case OP_MINUS:
                expression.addInputSymbol(InputSymbol.OP_MINUS);
                return new NoOperationState(expression);
            case OP_PLUS:
                expression.addInputSymbol(InputSymbol.OP_PLUS);
                return new NoOperationState(expression);
            case OP_MULTIPLY:
                expression.addInputSymbol(InputSymbol.OP_MULTIPLY);
                return new NoOperationState(expression);
            case OP_DIVIDE:
                expression.addInputSymbol(InputSymbol.OP_DIVIDE);
                return new NoOperationState(expression);
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
            case DOT:
                expression.addInputSymbol(InputSymbol.DOT);
                return new FloatState(expression.getInputSymbols());
            case CLEAR:
                return new SignState();
            case BACK:
                expression.backspace();
                return new SignState(expression);
            case EQUALS:
                expression.evaluate();
                expression.addInputSymbol(InputSymbol.EQUALS);
                return new ResultState(expression);
            default:
                return this;
        }
    }
}
