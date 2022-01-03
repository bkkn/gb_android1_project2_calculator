package me.bkkn.gb_android1_project2_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.bkkn.gb_android1_project2_calculator.model.Expression;
import me.bkkn.gb_android1_project2_calculator.model.Model;
import me.bkkn.gb_android1_project2_calculator.model.states.SignState;
import me.bkkn.gb_android1_project2_calculator.utils.Utils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@@";
    private List<Button> digitButtonList;
    private ArrayList<Integer> digitButtonResourceList;
    private TextView output;
    private Button lookupButton;
    private Model model = new Model(new SignState(new Expression()));

    void updateModel(int buttonId) {
        model.updateState(buttonId);
    }

    private void updateView() {
        Expression expression = model.getState().getExpression();
        String expressionString = expression.toString();
        String resultString = "";
        if(expression.resultIsCalculated())
            resultString = expression.getResultString();
        this.output.setText(expressionString + resultString);
    }

    // Used to load the 'gb_android1_project2_calculator' library on application startup.
    static {
        System.loadLibrary("gb_android1_project2_calculator");
    }

    void appendToOutputOnButtonPressed(Button button) {
        output.setText(output.getText().toString() + button.getText());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setContext(this);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        initDigitButtons();
        output = findViewById(R.id.output_text_view);
        initOperations();
        initSpecialButtons();

        if (savedInstanceState != null && savedInstanceState.containsKey(Expression.KEY))
            output.setText(((Expression) savedInstanceState.get(Expression.KEY)).toString());
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged() called with: newConfig = [" + newConfig + "]");
        super.onConfigurationChanged(newConfig);
        // WHY HAS IT NEVER BEEN CALLED ?
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
        //outState.putParcelable(Expression.KEY, new Expression(output.getText()));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onRestoreInstanceState(savedInstanceState);
        Utils.setContext(this);
        String str = ((Expression) savedInstanceState.getParcelable(Expression.KEY)).toString();
        output.setText(str);
    }

    private void initDigitButtons() {
        initResourceList();
        initDigitButtonList();
    }

    private void initOperations() {
        findViewById(R.id.plus_button).setOnClickListener(v -> {
            updateModel(R.id.plus_button);
            updateView();
        });
        findViewById(R.id.minus_button).setOnClickListener(v -> {
            updateModel(R.id.minus_button);
            updateView();
        });
        findViewById(R.id.multiply_button).setOnClickListener(v -> {
            updateModel(R.id.multiply_button);
            updateView();
        });
        findViewById(R.id.divide_button).setOnClickListener(v -> {
            updateModel(R.id.divide_button);
            updateView();
        });
        findViewById(R.id.equals_button).setOnClickListener(v -> {
            updateModel(R.id.equals_button);
            updateView();
        });

        findViewById(R.id.clear_button).setOnClickListener(v -> {
            updateModel(R.id.clear_button);
            updateView();
        });
        findViewById(R.id.backspace_button).setOnClickListener(v -> {
            updateModel(R.id.backspace_button);
            String text = (String) output.getText();
            if (!text.isEmpty())
                output.setText(text.subSequence(0, text.length() - 1));
        });
    }


    private void initSpecialButtons() {
        findViewById(R.id.dot_button).setOnClickListener(v -> {updateModel(R.id.dot_button); updateView();});
        findViewById(R.id.sign_button).setOnClickListener(v -> {updateModel(R.id.sign_button);updateView();});
        lookupButton = findViewById(R.id.lookup_button);
        lookupButton.setOnClickListener(view -> {
            startActivity(new Intent().setClass(this, LookupActivity.class));
            // .putExtra(Expression.KEY, new Expression(output.getText())));
            startActivity(new Intent(this, LookupActivity.class)
                    .putExtra(Expression.KEY, "stub"));
        });
    }

    void initResourceList() {
        digitButtonResourceList = new ArrayList<Integer>(Arrays.asList(
                R.id.digit_zero_button,
                R.id.digit_one_button,
                R.id.digit_two_button,
                R.id.digit_three_button,
                R.id.digit_four_button,
                R.id.digit_five_button,
                R.id.digit_six_button,
                R.id.digit_seven_button,
                R.id.digit_eight_button,
                R.id.digit_nine_button));
    }

    void initDigitButtonList() {
        digitButtonList = new ArrayList<>();
        for (int resourceId : digitButtonResourceList) {
            final Button[] button = {findViewById(resourceId)};
            button[0].setOnClickListener(v -> {
                updateModel(resourceId);
                updateView();
            });
            digitButtonList.add(button[0]);
        }
    }
}