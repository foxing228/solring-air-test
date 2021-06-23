package com.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(10);
        list.add(15);
        System.out.println(calcSum(10));
        System.out.println(reverse(list).toString());
        System.out.println(getDistance("ab", "bb"));
        System.out.println(getDistance("conversationalists", "conversationalists"));
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> list) {
        if (list.size() < 0 || list.size() > (int) Math.pow(10, 9)) throw new IllegalArgumentException("invalid length");
        int lastElem = list.size() - 1;
        return (ArrayList<Integer>) IntStream.rangeClosed(0, lastElem)
                .map(i -> (lastElem - i))
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }


    public static Integer calcSum(Integer n) {
        if (Math.abs(n) < 0 || Math.abs(n) > 10000) throw new IllegalArgumentException("invalid length");
        if (n < 0) return IntStream.rangeClosed(n, 0).sum();
        return IntStream.rangeClosed(0, n).sum();
    }

    public static Integer getDistance(String a, String b) {
        Integer bothLen = a.length() + b.length();

        if (bothLen < 0 || bothLen > 1000) throw new IllegalArgumentException("invalid input");

        if (a.length() < 0 || b.length() < 0 || a.length() > 1000 || b.length() > 1000) throw new IllegalArgumentException("invalid input");

        Map<Character,Integer> map = new HashMap();

        for(char i : a.toCharArray()){
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        int count  = 0;

        for(int i = 0;i< b.length();i++){

            char c = b.charAt(i);

            if(!map.containsKey(c)){
                count++;
            }

            else {

                int temp = map.get(c);

                if(temp == 1){
                    map.remove(c);
                }

                else {
                    map.put(c,temp - 1);
                }
            }
        }
        return count;
    }
}
