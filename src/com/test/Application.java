package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        System.out.println(calcSum(10));
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
