package me.bkkn.gb_android1_project2_calculator.model.states;

import java.util.List;
import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;

public class ZeroState extends BaseState {
    public ZeroState(List<InputSymbol> input) {
        this.expression.addInputSymbols(input);
    }

    @Override
    public BaseState onClickButton(InputSymbol inputSymbol) {
        switch (inputSymbol) {
            case DOT:
                expression.addInputSymbol(InputSymbol.DOT);
                return new FloatState(expression.getInputSymbols());
            case CLEAR:
                return new SignState();
            default:
                return this;
        }
    }
}
