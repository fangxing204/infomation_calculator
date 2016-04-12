package cal.fangxing.pers.calculator.expression;

import android.util.Log;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Created by fangxing on 4/12/16.
 */
public class Expression {
    public static String getResult(String expression) {
       /*Calculable calc = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)")
               .withVariable("x", varX)
               .withVariable("y", varY)
               .build()
       double result1=calc.calculate();*/


  /* Custom Function

    CustomFunction fooFunc = new CustomFunction("foo") {
            public double applyFunction(double[] values) {
                return values[0]*Math.E;
            }
        };
        double varX=12d;
        Calculable calc = new ExpressionBuilder("foo(x)")
                .withCustomFunction(fooFunc)
                .withVariable("x",varX)
                .build();
        assertTrue(calc.calculate() == Math.E * varX);
        */
        Calculable calc;
        AvgInfomation avgInfo = null;
        SelfInfomation selfInfomation = null;
        Ln ln = null;
        Log2 log2 = null;
        try {
            avgInfo = new AvgInfomation("H");
            selfInfomation = new SelfInfomation("I", 1);
            ln = new Ln("ln");
            log2 = new Log2("log2");

        } catch (InvalidCustomFunctionException e) {
            e.printStackTrace();
        }
        if (expression.trim().equals("")) return "";
        try {
            calc = new ExpressionBuilder(expression).
                    withCustomFunction(avgInfo).
                    withCustomFunction(selfInfomation).
                    withCustomFunction(ln).
                    withCustomFunction(log2)
                    .build();
        } catch (Exception e) {
            Log.e("error", e.getMessage());
            return " error! ";
        }
        return String.valueOf(calc.calculate());
    }
}
