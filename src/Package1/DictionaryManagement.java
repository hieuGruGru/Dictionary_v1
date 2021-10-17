package Package1;

import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {

    public static void insertFromCommandline(Dictionary dictionary1) { //Thêm từ mới từ commandline ( Nếu chưa có từ đó trong từ điển )

        System.out.println("Hãy nhập từ mới vào đây : ");
        Scanner sc = new Scanner(System.in);
        Word newWord = new Word();
        newWord.setWord_target(sc.nextLine());

        if (Search.linearSearch(dictionary1, newWord) == 0) {
            System.out.println("Từ này chưa tồn tại trong từ điển, hãy nhập nghĩa của nó vào : ");
            newWord.setWord_explain(sc.nextLine());
            dictionary1.arrayOfWord.add(newWord);
        } else {
            System.out.println("Từ này đã tồn tại trong từ điển rồi ");
        }
    }

    public static void insertOneWordFromCommandline(Dictionary dictionary1, String string) {

        Scanner sc = new Scanner(System.in);
        Word newWord = new Word();
        newWord.setWord_target(string);
        System.out.println("Hãy nhập nghĩa của từ " + string + " :");
        newWord.setWord_explain(sc.nextLine());
    }

    public static void insertFromFile(Dictionary dictionary1) throws IOException { //Load các cặp từ từ file .txt vào mảng các Word

        File filename = new File("D:/java/Dictionary_v1/src/Package1/dictionaries.txt");
        Scanner sc = new Scanner(filename);
        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            int indexOfTab = currentLine.indexOf("\t");
            //System.out.println("Vi tri dau tab la : " + indexOfTab);
            String word = currentLine.substring(0, indexOfTab);
            //System.out.println("Tu dau tien la : " + word);
            String meanings = currentLine.substring(indexOfTab + 1, currentLine.length());
            //System.out.println("Tu thu hai la : " + meanings);
            Word newWord = new Word(word, meanings);
            dictionary1.arrayOfWord.add(newWord);
        }
        sc.close();
    }


    /**
     *
     */
    public static void dictionaryLookup(Dictionary dictionary1) { //Tra nghĩa của 1 từ tiếng anh trong từ điển
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãu nhập từ cần tra nghĩa : ");
        String stringLookup = sc.nextLine();//Lấy đúng stringLookup rồi
        Word wordLookup = new Word(stringLookup,"");//wordLookup nhận đúng giá trị
        int indexOfWordLookup = Search.linearSearch(dictionary1, wordLookup);
        if ( indexOfWordLookup > -1 ) {
            System.out.println("Đã có từ này trong từ điển : ");
            DictionaryCommandline.showOneWords(dictionary1, indexOfWordLookup);
        } else {
            System.out.println("Từ này chưa có trong từ điển : ");
            DictionaryManagement.insertOneWordFromCommandline(dictionary1,stringLookup);
        }
    }

    /**
     * Chưa check nếu từ đã tồn tại thì không ghi vào file nữa
     * @param dictionary1
     * @throws IOException
     */
    public static void exportToFile(Dictionary dictionary1) throws IOException { //Ghi các từ mới vào file .txt
        File fileOut = new File("D:/java/Dictionary_v1/src/Package1/dictionaries1.txt");
        FileWriter fileWriter = new FileWriter(fileOut,true);
        BufferedWriter bWrite = new BufferedWriter(fileWriter);
        for(int i = 0; i < dictionary1.arrayOfWord.size(); i ++) {
            bWrite.write(dictionary1.arrayOfWord.get(i).getWord_target() + "\t");
            bWrite.write(dictionary1.arrayOfWord.get(i).getWord_explain() + "\n");
        }
        bWrite.close();

    }

    public static void deleteWord(Dictionary dictionary1, String string) {
        Word wordLookup = new Word(string,"");
        int indexOfWordDelete = Search.linearSearch(dictionary1, wordLookup);
        dictionary1.arrayOfWord.remove(indexOfWordDelete);
    }

}






