package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {

  private String outputStr = "";
  private int res= 0;
  @Override
  public String output() {

    return this.outputStr.length()==0?"0":this.outputStr;
  }

  @Override
  public void insertDigit(int digit) {
    if(digit<0||digit>9){
      throw new IllegalArgumentException();
    }
    String digitStr = String.valueOf(digit);
    this.outputStr+=digitStr;
  }

  @Override
  public void insertPlus() {
    if(this.outputStr.equals("")) {
      this.outputStr="0+";
    } else{
      String lastChar = this.outputStr.substring(this.outputStr.length() - 1);
      if(!lastChar.equals("+") && !lastChar.equals("-"))
      this.outputStr+="+";
    }
  }

  @Override
  public void insertMinus() {
    if(this.outputStr.equals("")) {
      this.outputStr="0-";
    }else{
      String lastChar = this.outputStr.substring(this.outputStr.length() - 1);
      if(!lastChar.equals("+") && !lastChar.equals("-"))
        this.outputStr+="-";
    }
  }

  private void calcRes() {
    if(this.outputStr.charAt(0) == '-'){
        this.outputStr="0"+this.outputStr;
    }
    String[] parts = this.outputStr.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    double result = Double.parseDouble(parts[0]);
    for (int i = 1; i < parts.length; i += 2) {
      String op = parts[i];
      double val = Double.parseDouble(parts[i+1]);
      switch (op) {
        case "+" :
          result += val;
          break;
        case "-" :
          result -= val;
          break;
      }
    }
    this.res = (int)result;
  }

  @Override
  public void insertEquals() {
    if(this.outputStr.length()==0) {
      this.res = 0;
      this.outputStr = String.valueOf(this.res);
      return;
    }
    String lastChar = this.outputStr.substring(this.outputStr.length() - 1);
    if(!lastChar.equals("+") && !lastChar.equals("-")){
      calcRes();
      this.outputStr=String.valueOf(this.res);
    }
  }

  @Override
  public void deleteLast() {
    if(!this.outputStr.equals("")){
      this.outputStr= this.outputStr.substring(0, this.outputStr.length() - 1);
    }
  }

  @Override
  public void clear() {
    this.outputStr = "";
    this.res= 0;
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    state.setState(this.outputStr);
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    this.outputStr=casted.getOutputStr();
  }

  private static class CalculatorState implements Serializable {
    private String outputStr = "";

    public void setState(String output){
      this.outputStr=output;
    }
    public String getOutputStr(){
      return this.outputStr;
    }

  }
}
