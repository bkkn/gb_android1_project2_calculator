package me.bkkn.gb_android1_project2_calculator.model.states;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.model.Expression;

/**
 * Самое первое состояние, ожидаем ввода знака (минус) или числа
 */
public class SignState extends BaseState {
    public SignState(Expression expression) {
        this.expression = expression;
    }

    public SignState() {
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case OP_MINUS:
                expression.addInputSymbol(InputSymbol.OP_MINUS);
                return new FirstIntState(expression.getInputSymbols());
            case OP_PLUS:
                return this;
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
                return new SignState(expression);
            case BACK:
                expression.backspace();
                return new SignState(expression);
            default:
                return this;
        }
    }
}
