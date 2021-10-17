package Package1;

import java.io.IOException;

public class DictionaryCommandline {


    public static void showAllWords(Dictionary dictionary1) { //Hiển thị tất cả các cặp từ trong từ điển
        System.out.println("No|         | English            | Vietnamese             ");
        for(int i = 0; i <  dictionary1.arrayOfWord.size(); i ++) {
            int separate = dictionary1.arrayOfWord.get(i).getWord_target().length();
            StringBuilder separateString = new StringBuilder();
            writeSpace(separateString, 19 - separate);
            System.out.println( (i + 1) + "           | " + dictionary1.arrayOfWord.get(i).getWord_target()
                    + separateString + "| " + dictionary1.arrayOfWord.get(i).getWord_explain() );
        }
    }

    public static void showOneWords(Dictionary dictionary1, int index) { //Hiển thị nghĩa của từ cần tìm
        int separate = dictionary1.arrayOfWord.get(index).getWord_target().length();
        StringBuilder separateString = new StringBuilder();
        writeSpace(separateString, 19 - separate);
        System.out.println("No|         | English            | Vietnamese             ");
        System.out.println( (index + 1) + "           | " + dictionary1.arrayOfWord.get(index).getWord_target()
                + separateString + "| " + dictionary1.arrayOfWord.get(index).getWord_explain() );
    }

    public static void dictionarySearcher() { //Liệt kê các từ có phần đầu trùng với chuỗi nhập vào


    }
    public static void dictionaryBasic(Dictionary dictionary1) throws IOException { //Từ điển đơn giản, có chức năng thêm từ mới từ commandline và hiển thị tất cả từ điển
        DictionaryCommandline.showAllWords(dictionary1);
        DictionaryManagement.insertFromCommandline(dictionary1);
        DictionaryManagement.exportToFile(dictionary1);
        DictionaryCommandline.showAllWords(dictionary1);
    }

    public static void dictionaryAdvenced(Dictionary dictionary1) throws IOException { //Từ điển nâng cao, có chức năng nạp từ từ file .txt, tìm kiếm từ và hiển thị tất cả từ điển
        DictionaryManagement.insertFromFile(dictionary1);
        DictionaryCommandline.showAllWords(dictionary1);
        DictionaryManagement.dictionaryLookup(dictionary1);
    }
    public static String writeSpace(StringBuilder separateString, int n) { //Tạo chuỗi khoảng trắng với độ dài nhất định, nhằm căn dòng khi hiển thị từ điển
        for (int i = 0; i < n; i ++) {
            separateString = separateString.append(" ");
        }
        return separateString.toString();
    }
}

