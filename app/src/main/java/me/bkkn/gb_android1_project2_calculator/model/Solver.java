package me.bkkn.gb_android1_project2_calculator.model;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class Solver {
    public static String solve(String expression) {
    Context context = Context.enter();
    context.setOptimizationLevel(-1); // this is required[2]
    Scriptable scope = context.initStandardObjects();
    Object result = context.evaluateString(scope, expression, "<cmd>", 1, null);
        return result.toString();
    }
}
