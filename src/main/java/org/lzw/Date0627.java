package org.lzw;

//2734
public class Date0627 {
    public static void main(String[] args) {
        Date0627 date0626 = new Date0627();
//        System.out.println(date0626.smallestString("cbabc"));
//        System.out.println(date0626.smallestString("acbbc"));
//        System.out.println(date0626.smallestString("leetcode"));
//        System.out.println(date0626.smallestString("aa"));
        System.out.println(date0626.smallestString("baa"));
    }

    public String smallestString(String s) {
        int left = 0;
        while (s.charAt(left) == 'a') {
            left++;
            if (left == s.length()) return s.substring(0, s.length() - 1) + "z";
        }
        int right = s.substring(left).indexOf('a') + left;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s, 0, left);
        if (left < right) {
            //aaa???a??
            for (int i = left; i < right; i++) {
                stringBuilder.append((char) (s.charAt(i) - 1));
            }
            stringBuilder.append(s.substring(right));
        } else {
            for (int i = left; i < s.length(); i++) {
                stringBuilder.append((char) (s.charAt(i) - 1));
            }
        }
        return stringBuilder.toString();
    }
}
