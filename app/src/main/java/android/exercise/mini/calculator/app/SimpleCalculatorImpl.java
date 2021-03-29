package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {

  private String outputStr = "";
  private int res= 0;
  private String curNum = "";
  private String lastAction = "";
  @Override
  public String output() {
    // todo: return output based on the current state
    return this.outputStr;
  }

  @Override
  public void insertDigit(int digit) {
    String digitStr = String.valueOf(digit);
    this.curNum += digitStr;
    this.outputStr+=digitStr;
  }

  @Override
  public void insertPlus() {
    if(!this.curNum.equals("")) {
      this.outputStr+="+";
      calcRes();
      this.lastAction="+";
    }
  }

  @Override
  public void insertMinus() {
    if(!this.curNum.equals("")) {
      this.outputStr+="-";
      calcRes();
      this.lastAction="-";
    }
  }

  private void calcRes() {
    if(this.lastAction.equals("")){
      this.res = Integer.parseInt(this.curNum);
    } else if (this.lastAction.equals("+")) {
      this.res += Integer.parseInt(this.curNum);
    } else {
      this.res -= Integer.parseInt(this.curNum);
    }
    this.curNum="";
  }

  @Override
  public void insertEquals() {
    calcRes();
    this.lastAction="";
    this.outputStr=String.valueOf(this.res);
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
  }

  @Override
  public void deleteLast() {
    if(!this.outputStr.equals("")){
      String lastChar = this.outputStr.substring(this.outputStr.length() - 1);
      if(lastChar.equals("+") || lastChar.equals("-")){
        this.lastAction="";
      }else{
        this.outputStr=this.outputStr.length()==0?"": this.outputStr.substring(0, this.outputStr.length() - 1);
        this.curNum=this.curNum.length()==0?"":this.curNum.substring(0, this.curNum.length() - 1);
      }
    }

    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
  }

  @Override
  public void clear() {
    this.outputStr = "";
    this.res= 0;
    this.curNum = "";
    this.lastAction = "";
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    state.setState(this.outputStr,this.res,this.curNum,this.lastAction);
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    this.outputStr=casted.getOutputStr();
    this.curNum=casted.getCurNum();
    this.lastAction=casted.lastAction;
    this.res=casted.getRes();
  }

  private static class CalculatorState implements Serializable {
    private String outputStr = "";
    private int res= 0;
    private String curNum = "";
    private String lastAction = "";

    public void setState(String output, int res, String curNum, String lastAction){
      this.outputStr=output;
      this.res=res;
      this.curNum=curNum;
      this.lastAction=lastAction;
    }
    public String getOutputStr(){
      return this.outputStr;
    }
    public String getCurNum(){
      return this.curNum;
    }
    public String getLastAction(){
      return this.lastAction;
    }
    public int getRes(){
      return this.res;
    }


    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
  }
}
