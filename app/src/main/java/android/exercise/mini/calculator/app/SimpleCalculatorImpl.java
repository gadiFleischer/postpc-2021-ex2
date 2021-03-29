package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {

  private String outputStr = "";
  private int res= 0;
  private String curNum = "";
  private String lastAction = "";
  @Override
  public String output() {
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
    if(!this.curNum.equals(""))
      this.outputStr+="-";
      calcRes();
      this.lastAction="-";
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
    this.curNum= String.valueOf(this.res);
  }

  @Override
  public void deleteLast() {
    if(!this.outputStr.equals("")){
      String lastChar = this.outputStr.substring(this.outputStr.length() - 1);
      if(lastChar.equals("+") || lastChar.equals("-")){
        this.lastAction="";
      }else{
        this.curNum=this.curNum.length()==0?"":this.curNum.substring(0, this.curNum.length() - 1);
      }
      this.outputStr= this.outputStr.substring(0, this.outputStr.length() - 1);
    }
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
    this.lastAction=casted.getLastAction();
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
  }
}
