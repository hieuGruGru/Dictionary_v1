package Package1;

import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {


    public static void showAllWords(Dictionary dictionary1) { //Hiển thị tất cả các cặp từ trong từ điển
        lineTemplate();
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
        System.out.println( (index + 1) + "           | " + dictionary1.arrayOfWord.get(index).getWord_target()
                + separateString + "| " + dictionary1.arrayOfWord.get(index).getWord_explain() );
    }

    public static void lineTemplate() {
        System.out.println("No|         | English            | Vietnamese             ");
    }

    public static void dictionarySearcher(Dictionary dictionary1) { //Liệt kê các từ có phần đầu trùng với chuỗi nhập vào
        System.out.println("Hãy nhập từ cần tra :");
        Scanner sc = new Scanner(System.in);
        String prefixString = sc.nextLine();
        System.out.println("Các từ có phần đầu trùng với '" + prefixString + "' la :");
        lineTemplate();
        for (int index  = 0; index < dictionary1.arrayOfWord.size(); index ++ ) {
            String word_target = dictionary1.arrayOfWord.get(index).getWord_target();
            if (word_target.toLowerCase().indexOf(prefixString.toLowerCase()) == 0) {//So sánh xem prefixString có phải là phần đầu của một từ trong từ điển không
                showOneWords(dictionary1, index);
            }
        }
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

