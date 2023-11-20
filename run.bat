javac predictive/PredictivePrototype.java
javac predictive/Words2SigProto.java
javac predictive/Sigs2WordsProto.java

cd predictive
java -cp .. predictive.Words2SigProto home hello world my name is
java -cp .. predictive.Sigs2WordsProto 4663 43556 96753 69 6263 47 329
cd ..