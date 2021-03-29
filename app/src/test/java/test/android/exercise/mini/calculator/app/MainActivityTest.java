package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.MainActivity;
import android.exercise.mini.calculator.app.R;
import android.exercise.mini.calculator.app.SimpleCalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.io.Serializable;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {28})
public class MainActivityTest {

  private static final String DEFAULT_CALCULATOR_OUTPUT = "~~~ ready to start ~~~";

  private ActivityController<MainActivity> activityController;
  private MainActivity activityUnderTest;
  private SimpleCalculator mockCalculator;

  /** initialize main activity with a mock calculator */
  @Before
  public void setup(){
    mockCalculator = Mockito.mock(SimpleCalculator.class);
    Mockito.when(mockCalculator.output()).thenReturn(DEFAULT_CALCULATOR_OUTPUT);

    activityController = Robolectric.buildActivity(MainActivity.class);
    activityUnderTest = activityController.get();
    activityUnderTest.calculator = mockCalculator;
    activityController.create().start().resume();
  }

  @Test
  public void when_settingUpTheActivity_then_itShouldShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = DEFAULT_CALCULATOR_OUTPUT;
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    // verify
    assertEquals(expectedText, activityMainTextView.getText().toString());
  }

  @Test
  public void when_userClicksButtonPlus_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button PLUS clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View buttonPlus = activityUnderTest.findViewById(R.id.buttonPlus);

    // test
    buttonPlus.performClick();

    // verify
    Mockito.verify(mockCalculator).insertPlus(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void minusClick() {
    // setup
    String expectedText = "button MINUS clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View buttonMinus = activityUnderTest.findViewById(R.id.buttonMinus);
    // test
    buttonMinus.performClick();
    // verify
    Mockito.verify(mockCalculator).insertMinus(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void equalsClick() {
    // setup
    String expectedText = "button EQUALS clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.buttonEquals);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertEquals(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void backspaceClick() {
    // setup
    String expectedText = "button BACKSPACE clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.buttonBackSpace);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).deleteLast(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void clearClick() {
    // setup
    String expectedText = "button CLEAR clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.buttonClear);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).clear(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void button0() {
    // setup
    String expectedText = "button 0 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button0);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(0); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void button1() {
    // setup
    String expectedText = "button 1 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button1);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(1); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test
  public void button2() {
    // setup
    String expectedText = "button 2 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button2);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(2); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test

  public void button3() {
    // setup
    String expectedText = "button 3 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button3);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(3); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test

  public void button4() {
    // setup
    String expectedText = "button 5 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button4);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(4); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test

  public void button5() {
    // setup
    String expectedText = "button 5 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button5);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(5); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test

  public void button6() {
    // setup
    String expectedText = "button 6 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button6);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(6); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test

  public void button7() {
    // setup
    String expectedText = "button 7 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button7);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(7); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test

  public void button8() {
    // setup
    String expectedText = "button 8 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button8);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(8); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  @Test

  public void button9() {
    // setup
    String expectedText = "button 9 clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);
    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View button = activityUnderTest.findViewById(R.id.button9);
    // test
    button.performClick();
    // verify
    Mockito.verify(mockCalculator).insertDigit(9); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }
  // TODO: add tests for clicks on all buttons


  @Test
  public void when_activityGetsStateSaved_then_shouldAlsoSaveCalculatorState() {
    // setup
    Serializable dummyState = new Serializable() {};
    Mockito.when(mockCalculator.saveState()).thenReturn(dummyState);

    Bundle spyBundle = Mockito.spy(new Bundle());

    // test
    activityController.saveInstanceState(spyBundle);

    // verify
    Mockito.verify(spyBundle).putSerializable(anyString(), eq(dummyState)); // make sure that the activity stored the calculator state into the spy bundle
  }


  @Test
  public void when_activityGetsStateRestored_then_shouldAlsoSaveCalculatorState() {
    // setup
    Serializable dummyState = new Serializable() {};
    Mockito.when(mockCalculator.saveState()).thenReturn(dummyState);

    // let the activity store the calculator state into the bundle
    Bundle spyBundle = Mockito.spy(new Bundle());
    activityController.saveInstanceState(spyBundle);

    // test
    activityController.restoreInstanceState(spyBundle);

    // verify
    Mockito.verify(mockCalculator).loadState(eq(dummyState)); // make sure that the activity passed the previously-stored state to the calculator to load
  }
}