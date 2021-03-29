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
//      savedInstanceState.putInt("calc_output",0);
//      savedInstanceState.putString("calc_str_output","");
    }
//    calcStr =  savedInstanceState.getString("calc_str_output");
//    calcOutput = savedInstanceState.getInt("calc_output");
//    //find all views
    TextView button0 = findViewById(R.id.button0);
    TextView button1 = findViewById(R.id.button1);
    TextView button2 = findViewById(R.id.button2);
    TextView button3 = findViewById(R.id.button3);
    TextView button4 = findViewById(R.id.button4);
    TextView button5 = findViewById(R.id.button5);
    TextView button6 = findViewById(R.id.button6);
    TextView button7 = findViewById(R.id.button7);
    TextView button8 = findViewById(R.id.button8);
    TextView button9 = findViewById(R.id.button9);
    View buttonBackspace = findViewById(R.id.buttonBackSpace);
    View spaceBelowButton1 = findViewById(R.id.spaceBelowButton1);
    ImageView backSpaceImage = findViewById(R.id.backSpaceImage);
    TextView buttonClear = findViewById(R.id.buttonClear);
    TextView buttonPlus = findViewById(R.id.buttonPlus);
    TextView buttonMinus = findViewById(R.id.buttonMinus);
    TextView buttonEquals = findViewById(R.id.buttonEquals);
    TextView textViewOutput = findViewById(R.id.textViewCalculatorOutput);
    textViewOutput.setText("");
//    textViewOutput.setText(savedInstanceState.getInt("calc_output"));

//    // set listeners
    button0.setOnClickListener(v -> {
      calculator.insertDigit(0);
      textViewOutput.setText(calculator.output());
    });
    button1.setOnClickListener(v -> {
      calculator.insertDigit(1);
      textViewOutput.setText(calculator.output());
    });
    button2.setOnClickListener(v -> {
      calculator.insertDigit(2);
      textViewOutput.setText(calculator.output());
    });
    button3.setOnClickListener(v -> {
      calculator.insertDigit(3);
      textViewOutput.setText(calculator.output());
    });
    button4.setOnClickListener(v -> {
      calculator.insertDigit(4);
      textViewOutput.setText(calculator.output());
    });
    button5.setOnClickListener(v -> {
      calculator.insertDigit(5);
      textViewOutput.setText(calculator.output());
    });
    button6.setOnClickListener(v -> {
      calculator.insertDigit(6);
      textViewOutput.setText(calculator.output());
    });
    button7.setOnClickListener(v -> {
      calculator.insertDigit(7);
      textViewOutput.setText(calculator.output());
    });
    button8.setOnClickListener(v -> {
      calculator.insertDigit(8);
      textViewOutput.setText(calculator.output());
    });
    button9.setOnClickListener(v -> {
      calculator.insertDigit(9);
      textViewOutput.setText(calculator.output());
    });
    buttonBackspace.setOnClickListener(v ->{
      calculator.deleteLast();
      textViewOutput.setText(calculator.output());
    });
    buttonClear.setOnClickListener(v ->{
      calculator.clear();
      textViewOutput.setText(calculator.output());
    });
    buttonEquals.setOnClickListener(v ->{
      calculator.insertEquals();
      textViewOutput.setText(calculator.output());
    }) ;
    buttonMinus.setOnClickListener(v -> {
      calculator.insertMinus();
      textViewOutput.setText(calculator.output());
    });
    buttonPlus.setOnClickListener(v ->{
      calculator.insertPlus();
      textViewOutput.setText(calculator.output());
    });



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
//    outState.putInt("calc_output",calcOutput);
    // todo: save calculator state into the bundle
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
//    savedInstanceState.putInt("calc_output",0);
//    TextView textViewOutput = findViewById(R.id.textViewCalculatorOutput);
//    textViewOutput.setText(0);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
  }
}