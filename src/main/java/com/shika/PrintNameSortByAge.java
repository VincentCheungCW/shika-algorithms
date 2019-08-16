package com.shika;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 题目：HashMap存了若干<name,age>这样的键值对，现在想按年龄排序，打印出姓名
 * 思路：即把<name,age>变为<age,name>且按照age排序
 * 考虑到age为整数且有范围，故采用链表数组，数组下标作为age
 */
public class PrintNameSortByAge {
    public static void printNameSortByAge(HashMap<String, Integer> map) {
        LinkedList<String>[] ageNameMap = new LinkedList[150]; //数组下标作为age,一般不会超过150岁
        for (String name : map.keySet()) {
            if (ageNameMap[map.get(name)] == null) {
                ageNameMap[map.get(name)] = new LinkedList<>();
                ageNameMap[map.get(name)].add(name);
            } else {
                ageNameMap[map.get(name)].add(name);
            }
        }
        for (int i = 0; i < ageNameMap.length; i++) {
            if (ageNameMap[i] != null) {
                System.out.println(i + ":");
                for (int i1 = 0; i1 < ageNameMap[i].size(); i1++) {
                    System.out.println(ageNameMap[i].get(i1));
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 20);
        map.put("Bob", 10);
        map.put("Sam Smith", 29);
        map.put("Kanye West", 38);
        map.put("Adele", 28);
        map.put("Khalid", 20);
        map.put("Kendrick Lamar", 30);
        printNameSortByAge(map);
    }
}
