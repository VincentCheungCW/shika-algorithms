package com.shika;

/**
 * 将字符串中的空格替换为“%20”
 * 较小的空间和时间复杂度
 * 双指针，从后向前遍历
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer in) {
        int p1 = in.length() - 1;  //原字符串末尾位置
        /**
         * 先遍历一遍找出‘ ’
         */
        for (int i = 0; i <= p1; i++) {
            if (in.charAt(i) == ' ') {
                in.append("  ");
            }
        }
        int p2 = in.length() - 1;  //新字符串末尾位置
        for (int i = p1; i >= 0; i--) {
            if (in.charAt(i) == ' ') {
                in.setCharAt(p2--, '0');
                in.setCharAt(p2--, '2');
                in.setCharAt(p2--, '%');
            } else {
                in.setCharAt(p2--, in.charAt(i));
            }
        }
        return in.toString();
    }
}
