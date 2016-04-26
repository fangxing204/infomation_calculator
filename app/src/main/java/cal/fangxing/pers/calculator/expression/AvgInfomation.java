package cal.fangxing.pers.calculator.expression;

import de.congrace.exp4j.CustomFunction;
import de.congrace.exp4j.InvalidCustomFunctionException;

/**
 * Created by fangxing on 4/12/16.
 */
public class AvgInfomation extends CustomFunction {
    protected AvgInfomation(String name) throws InvalidCustomFunctionException {
        super(name);
    }
    @Override
    public double applyFunction(double[] values){
        double infoSum = 0;
        double sum = 0; //用于检查概率和是否为一
        for (double v : values) {
           infoSum +=  - v * ( Math.log(v) / Math.log( 2 ) );
            sum += v;
        }
        return infoSum;
    }
}
