package me.bkkn.gb_android1_project2_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.bkkn.gb_android1_project2_calculator.model.Expression;

public class LookupActivity extends AppCompatActivity {
    private static final String TAG = "@@@ Lookup";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookup_activity);

        Expression expression = ((Expression) getIntent().getParcelableExtra(Expression.KEY));
        String input = expression.toString();
        double result = expression.evaluate();

        ((TextView) findViewById(R.id.lookup_input_edit_text)).setText(input);
        ((TextView) findViewById(R.id.lookup_result_edit_text)).setText( String.valueOf(result));
    }
}
