package me.bkkn.gb_android1_project2_calculator.model;

import android.util.Log;

import me.bkkn.gb_android1_project2_calculator.entities.InputSymbol;
import me.bkkn.gb_android1_project2_calculator.model.states.BaseState;
import me.bkkn.gb_android1_project2_calculator.utils.Utils;

public class Model {
    private BaseState state;

    public Model(BaseState state) {
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
