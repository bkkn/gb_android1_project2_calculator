package me.bkkn.gb_android1_project2_calculator.model;

import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.CLEAR;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.DOT;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_0;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_1;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_2;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_3;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_4;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_5;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_6;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_7;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_8;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.NUM_9;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.OP_DIVIDE;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.OP_MINUS;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.OP_MULTIPLY;
import static me.bkkn.gb_android1_project2_calculator.entities.InputSymbol.OP_PLUS;

import android.util.Log;
import android.widget.Button;

import me.bkkn.gb_android1_project2_calculator.R;
import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.model.states.BaseState;
import me.bkkn.gb_android1_project2_calculator.model.states.FloatState;
import me.bkkn.gb_android1_project2_calculator.model.states.SignState;
import me.bkkn.gb_android1_project2_calculator.utils.Utils;

public class Model {
//    private Expression expression;
    private BaseState state;

    public Model(Expression expression, BaseState state) {
 //       this.expression = expression;
        this.state = state;
    }

    public BaseState getState() {
        return state;
    }

    public void setState(BaseState state) {
        this.state = state;
    }

    public void onClickButton(InputSymbol inputSymbol) {
        BaseState newState = state.onClickButton(inputSymbol);
        Log.d("@@@", "Old state = " + state.getClass().getSimpleName());
        Log.d("@@@", "Input symbol = " + inputSymbol.name());
        Log.d("@@@", "New state = " + newState.getClass().getSimpleName());
        Log.d("@@@", "\n");
        state = newState;
    }

    public void updateState(int buttonId) {
        onClickButton(Utils.buttonToInputSymbol(buttonId));
    }
}
