JCC = javac

JFLAGS = 

default: Calculator.class 

Calculator.class: Calculator.java Strategy.class
	$(JCC) $(JFLAGS) Calculator.java

Strategy.class: Strategy.java Add.class Subtract.class Multiply.class Divide.class Modulus.class
	$(JCC) $(JFLAGS) Strategy.java

Add.class: Add.java
	$(JCC) $(JFLAGS) Add.java

Subtract.class: Subtract.java
	$(JCC) $(JFLAGS) Subtract.java

Multiply.class: Multiply.java
	$(JCC) $(JFLAGS) Multiply.java

Divide.class: Divide.java
	$(JCC) $(JFLAGS) Divide.java

Modulus.class: Modulus.java
	$(JCC) $(JFLAGS) Modulus.java

clean: 
	$(RM) *.class