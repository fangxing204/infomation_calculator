package cal.fangxing.pers.calculator.expression;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Created by fangxing on 4/12/16.
 */
public class Log2 extends CustomFunction {

    protected Log2(String name) throws InvalidCustomFunctionException {
        super(name);
    }

    @Override
    public double applyFunction(double... args) {
        return Math.log(args[0]) / Math.log(2);
    }
}
