package me.bkkn.gb_android1_project2_calculator.model.states;

import java.util.ArrayList;
import java.util.List;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.model.Expression;


abstract public class BaseState {
    protected Expression expression = new Expression();

    public abstract BaseState onClickButton(InputSymbol inputSymbol);

    public Expression getExpression() {
        return new Expression(expression);
    }
}