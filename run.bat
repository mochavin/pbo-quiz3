javac predictive/PredictivePrototype.java predictive/Words2SigProto.java predictive/Sigs2WordsProto.java predictive/Sigs2WordsList.java predictive/DictionaryMapImpl.java predictive/DictionaryTreeImpl.java predictive/Sigs2WordsMap.java predictive/Sigs2WordsTree.java


cd predictive
java -cp .. predictive.Words2SigProto home hello world my name is


ECHO StartTimer %Time% >> .\timer\Timer-Sigs2WordsProto.txt
java -cp .. predictive.Sigs2WordsProto 4663 43556 96753 69 6263 47 329
ECHO StopTimer %Time% >> .\timer\Timer-Sigs2WordsProto.txt


ECHO StartTimer %Time% >> .\timer\Timer-Sigs2WordsList.txt
java -cp .. predictive.Sigs2WordsList 4663 43556 96753 69 6263 47 329
ECHO StopTimer %Time% >> .\timer\Timer-Sigs2WordsList.txt

java -cp .. predictive.DictionaryMapImpl 4663 43556 96753
java -cp .. predictive.DictionaryTreeImpl 4663 43556 96753

ECHO StartTimer %Time% >> .\timer\Timer-Sigs2WordsMap.txt
java -cp .. predictive.Sigs2WordsMap 4663 43556 96753 69 6263 47
ECHO StopTimer %Time% >> .\timer\Timer-Sigs2WordsMap.txt

ECHO StartTimer %Time% >> .\timer\Timer-Sigs2WordsTree.txt
java -cp .. predictive.Sigs2WordsTree 4663 43556 96753 69 6263 47
ECHO StopTimer %Time% >> .\timer\Timer-Sigs2WordsTree.txt

cd ..