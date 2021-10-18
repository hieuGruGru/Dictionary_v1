package Package1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Search { //Các phương thức tìm kiếm

    /**
     * public static int binarySearch(ArrayList<Word> arrayOfWord, Word word) //Phương thức tìm kiếm nhị phân O(logn)
     * {
     * int index = Collections.binarySearch(arrayOfWord,word);
     * if ( index < 0 ) {
     * return -1;
     * }
     * }
     */

    public static int linearSearch(Dictionary dictionary1, Word word) { //Phương thức tìm kiếm tuyến tính O(n)
        int flag = -1;
        for (int index = 0; index < dictionary1.arrayOfWord.size(); index++) {
            //System.out.println(arrayOfWord.get(index).getWord_target() + "\t" );
            if (dictionary1.arrayOfWord.get(index).getWord_target().equalsIgnoreCase(word.getWord_target()) == true ) { //Kiểm tra từ vừa nhập vào có trùng với
                                                                                                                        //các từ có sẵn trong từ điển hay không
                flag = index;
            }
        }
        return flag;
    }

}

