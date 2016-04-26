package cal.fangxing.pers.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cal.fangxing.pers.calculator.expression.Expression;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAinActivity";
    @Bind(R.id.input)
    TextView input;
    @Bind(R.id.resultText)
    TextView resultText;
    @Bind(R.id.one)
    Button one;
    @Bind(R.id.two)
    Button two;
    @Bind(R.id.three)
    Button three;
    @Bind(R.id.devide)
    Button devide;
    @Bind(R.id.four)
    Button four;
    @Bind(R.id.five)
    Button five;
    @Bind(R.id.six)
    Button six;
    @Bind(R.id.multiply)
    Button multiply;
    @Bind(R.id.seven)
    Button seven;
    @Bind(R.id.eight)
    Button eight;
    @Bind(R.id.nine)
    Button nine;
    @Bind(R.id.minus)
    Button minus;
    @Bind(R.id.zero)
    Button zero;
    @Bind(R.id.dot)
    Button dot;
    @Bind(R.id.ln)
    Button ln;
    @Bind(R.id.plus)
    Button plus;
    @Bind(R.id.log2)
    Button log2;
    @Bind(R.id.selfInfo)
    Button selfInfo;
    @Bind(R.id.avgInfo)
    Button avgInfo;
    @Bind(R.id.power)
    Button power;
    @Bind(R.id.equel)
    Button equel;
    @Bind(R.id.delete)
    Button delete;
    @Bind(R.id.clear)
    Button clear;
    @Bind(R.id.rBracket)
    Button rBracket;

    String inputContent;
    @Bind(R.id.comma)
    Button comma;
    @Bind(R.id.binary)
    Button binary;
    @Bind(R.id.lBracket)
    Button lBracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.one, R.id.two, R.id.three, R.id.devide, R.id.four, R.id.five, R.id.six, R.id.multiply, R.id.seven, R.id.eight, R.id.nine, R.id.minus, R.id.zero, R.id.dot, R.id.ln, R.id.plus, R.id.log2, R.id.selfInfo, R.id.avgInfo, R.id.power,R.id.comma, R.id.binary, R.id.lBracket, R.id.equel, R.id.delete, R.id.clear, R.id.rBracket})
    public void onClick(View view) {
        Log.i(TAG, "clicked----" + view.toString());
        inputContent = input.getText().toString();

        switch (view.getId()) {
            case R.id.one:
                input.append("1");
                break;
            case R.id.two:
                input.append("2");
                break;
            case R.id.three:
                input.append("3");
                break;
            case R.id.devide:
                input.append(" / ");
                break;
            case R.id.four:
                input.append("4");
                break;
            case R.id.five:
                input.append("5");
                break;
            case R.id.six:
                input.append("6");
                break;
            case R.id.multiply:
                input.append(" * ");
                break;
            case R.id.seven:
                input.append("7");
                break;
            case R.id.eight:
                input.append("8");
                break;
            case R.id.nine:
                input.append("9");
                break;
            case R.id.minus:
                input.append(" - ");
                break;
            case R.id.zero:
                input.append("0");
                break;
            case R.id.dot:
                input.append(".");
                break;
            case R.id.ln:
                input.append("ln( ");
                break;
            case R.id.plus:
                resultText.setText(Expression.getResult(inputContent));
                input.append(" + ");
                break;
            case R.id.log2:
                input.append("log2( ");
                break;
            case R.id.selfInfo:
                input.append("I( ");
                break;
            case R.id.avgInfo:
                input.append("H( ");
                break;
            case R.id.power:
                input.append(" ^ ");
                break;
            case R.id.equel:
                //input.append(" = ");
                resultText.setText(Expression.getResult(inputContent));
                break;
            case R.id.delete:
                inputContent = input.getText().toString();
                Log.e(TAG, "input content:[" + inputContent + "]");
                if (inputContent.equals("")) return;
                inputContent = inputContent.trim().substring(0, inputContent.length() - 1).trim();
                input.setText(inputContent);
                break;
            case R.id.clear:
                input.setText("");
                resultText.setText("");
                break;
            case R.id.rBracket:
                input.append(" )");
                break;
            case R.id.comma:
                input.append(", ");
                break;
            case R.id.binary:
                if(inputContent.trim().equals("")) return;
                if(inputContent.contains(".")) {
                    input.setText("sorry interger only!");
                    return;
                }
                Long i = Long.valueOf(inputContent);
                Log.e(TAG,"i:["+ i);

               resultText.setText(BigInteger.valueOf(i).toString(2));
                break;
            case R.id.lBracket:
                break;
        }
    }

}
