JCC = javac

JFLAGS = 

default: LudoGame

LudoGame: Model UI Strategies Graphics Actions

Model:
	$(JCC) $(JFLAGS) src/seng271/group8/ludo/model/*.java
UI:
	$(JCC) $(JFLAGS) src/seng271/group8/ludo/ui/*.java
Strategies:
	$(JCC) $(JFLAGS) src/seng271/group8/ludo/strategies/*.java
Graphics:
	$(JCC) $(JFLAGS) src/seng271/group8/ludo/graphics/*.java
Actions:
	$(JCC) $(JFLAGS) src/seng271/group8/ludo/actions/*.java

clean: 
	rm `find ./ -name '*.class'` -rf
