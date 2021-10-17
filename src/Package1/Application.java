package Package1;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary1 = new Dictionary();
        DictionaryManagement.insertFromFile(dictionary1);
        DictionaryCommandline.showAllWords(dictionary1);
        //DictionaryManagement.dictionaryLookup(dictionary1);
        //DictionaryCommandline.showAllWords(dictionary1);
        DictionaryCommandline.dictionarySearcher(dictionary1);
    }
}
