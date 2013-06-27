JCC = javac

JFLAGS = 

default: Ludogame.class 

Ludogame.class: Ludogame.java Strategy.class Dice.class Player.class
	$(JCC) $(JFLAGS) Ludogame.java

Strategy.class: Strategy.java AggressiveStrategy.class CautiousStrategy.class DefensiveStrategy.class MoveFirstStrategy.class MoveLastStrategy.class
	$(JCC) $(JFLAGS) Strategy.java

Player.class: Player.java Pawn.class
	$(JCC) $(JFLAGS) Player.java

Pawn.class: Pawn.java
	$(JCC) $(JFLAGS) Pawn.java

Dice.class: Dice.java
	$(JCC) $(JFLAGS) Dice.java

AggressiveStrategy.class: AggressiveStrategy.java
	$(JCC) $(JFLAGS) AggressiveStrategy.java

CautiousStrategy.class: CautiousStrategy.java
	$(JCC) $(JFLAGS) CautiousStrategy.java

DefensiveStrategy.class: DefensiveStrategy.java
	$(JCC) $(JFLAGS) DefensiveStrategy.java

MoveFirstStrategy.class: MoveFirstStrategy.java
	$(JCC) $(JFLAGS) MoveFirstStrategy.java

MoveLastStrategy.class: MoveLastStrategy.java
		$(JCC) $(JFLAGS) MoveLastStrategy.java

clean: 
	$(RM) *.class