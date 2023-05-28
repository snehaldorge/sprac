 module CalcApp
  {
  interface Calc
  {
  exception DivisionByZero {};
  float sum(in float a, in float b);
 float div(in float a, in float b) raises (DivisionByZero);
  float mul(in float a, in float b);
  float sub(in float a, in float b);
 };
 };
