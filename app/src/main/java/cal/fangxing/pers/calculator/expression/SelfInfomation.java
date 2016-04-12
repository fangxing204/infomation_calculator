package cal.fangxing.pers.calculator.expression;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Created by fangxing on 4/12/16.
 */
public class SelfInfomation extends CustomFunction {
    protected SelfInfomation(String name, int count) throws InvalidCustomFunctionException {
        super(name,count);
    }

    @Override
    public double applyFunction(double... args) {
        return - args[0] * ( Math.log(args[0] ) / Math.log( 2 ) );
    }
}
