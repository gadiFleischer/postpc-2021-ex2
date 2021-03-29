package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;
  private int calcOutput=0;
  private String calcStr;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
      savedInstanceState.putInt("calc_output",0);
      savedInstanceState.putString("calc_str_output","");
    }
//    calcStr =  savedInstanceState.getString("calc_str_output");
//    calcOutput = savedInstanceState.getInt("calc_output");
//    //find all views
//    TextView button0 = findViewById(R.id.button0);
//    TextView button1 = findViewById(R.id.button1);
//    TextView button2 = findViewById(R.id.button2);
//    TextView button3 = findViewById(R.id.button3);
//    TextView button4 = findViewById(R.id.button4);
//    TextView button5 = findViewById(R.id.button5);
//    TextView button6 = findViewById(R.id.button6);
//    TextView button7 = findViewById(R.id.button7);
//    TextView button8 = findViewById(R.id.button8);
//    TextView button9 = findViewById(R.id.button9);
//    View buttonBackspace = findViewById(R.id.buttonBackSpace);
//    View spaceBelowButton1 = findViewById(R.id.spaceBelowButton1);
//    ImageView backSpaceImage = findViewById(R.id.backSpaceImage);
//    TextView buttonClear = findViewById(R.id.buttonClear);
//    TextView buttonPlus = findViewById(R.id.buttonPlus);
//    TextView buttonMinus = findViewById(R.id.buttonMinus);
//    TextView buttonEquals = findViewById(R.id.buttonEquals);
//    TextView textViewOutput = findViewById(R.id.textViewCalculatorOutput);
//    textViewOutput.setText(savedInstanceState.getInt("calc_output"));
//
//    // set listeners
//    button0.setOnClickListener(v -> textViewOutput.setText(calcStr+"0"));
//    button1.setOnClickListener(v -> textViewOutput.setText("1"));
//    button2.setOnClickListener(v -> textViewOutput.setText("2"));
//    button3.setOnClickListener(v -> textViewOutput.setText("3"));
//    button4.setOnClickListener(v -> textViewOutput.setText("4"));
//    button5.setOnClickListener(v -> textViewOutput.setText("5"));
//    button6.setOnClickListener(v -> textViewOutput.setText("6"));
//    button7.setOnClickListener(v -> textViewOutput.setText("7"));
//    button8.setOnClickListener(v -> textViewOutput.setText("8"));
//    button9.setOnClickListener(v -> textViewOutput.setText("9"));
//    buttonBackspace.setOnClickListener(v -> textViewOutput.setText("todo"));
//    buttonClear.setOnClickListener(v -> textViewOutput.setText(""));
//    buttonEquals.setOnClickListener(v -> textViewOutput.setText("calc here"));
//    buttonMinus.setOnClickListener(v -> textViewOutput.setText("-"));
//    buttonPlus.setOnClickListener(v -> textViewOutput.setText("+"));



    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt("calc_output",calcOutput);
    // todo: save calculator state into the bundle
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    savedInstanceState.putInt("calc_output",0);
    TextView textViewOutput = findViewById(R.id.textViewCalculatorOutput);
    textViewOutput.setText(0);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
  }
}