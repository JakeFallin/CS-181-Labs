<snippet>
  <content>
# Lab 03



## Number 1

Using the code template on Canvas, write a program
Lab03_yourname.java in a package Lab3; that reads a periodic
binary number in the format “D.A_P” where D is the binary value
before the decimal point, A is the aperiodic value, and P is the
periodic value. For e.g. “10.0_0011” is the format for the Case 3
example discussed in class. Your code should provide the decimal
value for all possible cases. You may not use any Java built-in
functions to convert any part of the binary input value to integer
value; you must write all such methods yourself.(20 pts)
For e.g. running java Lab03_yourname 1 10.0_0011 returns 2.1.

## Number 2

Write a program that will generate the longest common substring
(ignoring case) between two given input strings S1 and S2. For e.g.
if S1 = “racecar” and S2 = “carpool” the longest common substring
is “car”. There is a small twist to this problem, you are also
required to find the longest common substring when only S1 is 
reversed, only S2 is reversed, and when both are reversed. For e.g.
when both S1 and S2 are reversed S1 = “racecar” (omg!) and S2 =
“looprac” the longest common substring is “rac”. (15 pts)
For e.g. running java Lab02_yourname 2 racecar carpool should
return car car rac rac. (First output is for S1 and S2, second one is
when S1 is reversed, third is when S2 is reversed, and finally when
S1 and S2 are reversed)

## Number 3

We looked at 3n +1 conjecture in class on Monday Week 4. We
define a transformation function T(n) = 3n +1 when n is odd and
T(n) = n /2 when n is even. We saw that the conjecture states that
for any value of n, T(n) converges to 1. We also saw why there is
no actual proof for it and why this is an open problem. Write a
program that will generate a string of all values generated from
the function till it converges to 1. (15 pts)
For e.g. running java Lab02_yourname 3 7 returns “22 11 34 17 52
26 13 40 20 10 5 16 8 4 2 1”.
Note – You are required to use while, do while or for loops. 

]]></content>
  <tabTrigger>readme</tabTrigger>
</snippet>