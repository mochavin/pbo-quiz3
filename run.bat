javac predictive/PredictivePrototype.java
javac predictive/Words2SigProto.java
javac predictive/Sigs2WordsProto.java
javac predictive/Sigs2WordsList.java

cd predictive
java -cp .. predictive.Words2SigProto home hello world my name is
ECHO StartTimer %Time% >> .\timer\Timer-Sigs2WordsProto.txt
java -cp .. predictive.Sigs2WordsProto 4663 43556 96753 69 6263 47 329
ECHO StopTimer %Time% >> .\timer\Timer-Sigs2WordsProto.txt
ECHO StartTimer %Time% >> .\timer\Timer-Sigs2WordsList.txt
java -cp .. predictive.Sigs2WordsList 4663 43556 96753 69 6263 47 329
ECHO StopTimer %Time% >> .\timer\Timer-Sigs2WordsList.txt
cd ..