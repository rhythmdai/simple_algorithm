package leetcode;

import java.util.*;

public class S791 {
    public String customSortString(String S, String T) {
        Map<Character,Integer> order = new HashMap<>();
        for(int i= 1 ;i<= S.length();i++){
            order.put(S.charAt(i-1),i);
        }
        List<Character> characters = new ArrayList<>(T.length());
        for(int i= 0 ;i< T.length();i++){
            characters.add(T.charAt(i));
        }
        return sort(characters,order);
    }

    public String sort(List<Character> characters , Map<Character,Integer> order){
        Map<Integer,StringBuilder> map = new HashMap<>();
        for(int i =1 ;i<=order.size() ; i++){
            map.put(i,new StringBuilder());
        }
        StringBuilder other = new StringBuilder();
        Set<Character> keys = order.keySet();
        for(Character c : characters){
           if(keys.contains(c)){
               map.get(order.get(c)).append(c);
           }else {
               other.append(c);
           }
        }
        StringBuilder result = new StringBuilder();
        for(int i=1 ;i<=order.size();i++){
            result.append(map.get(i));
        }
        result.append(other);
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new S791().customSortString("cba","abcd"));
    }
}
