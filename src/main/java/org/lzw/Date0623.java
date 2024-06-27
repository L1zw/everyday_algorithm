package org.lzw;

//520
public class Date0623 {
    public static void main(String[] args) {

    }

    //检测大小写字母
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        if (Character.isUpperCase(word.charAt(0))) {
            //首字母大写，后续的字符需要与第二个字符大小写一致
            boolean upperCase = Character.isUpperCase(word.charAt(1));
            for (int i = 2; i < word.length(); i++) {
                if (upperCase != Character.isUpperCase(word.charAt(i))) return false;
            }
            return true;
        } else {
            //首字母小写，全部小写
            for (int i = 1; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (Character.isUpperCase(curChar)) return false;
            }
            return true;
        }
    }
}
