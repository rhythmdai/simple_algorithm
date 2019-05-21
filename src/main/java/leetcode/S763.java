package leetcode;

import java.util.*;

public class S763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> indexList = new ArrayList<>(26);
        List<Integer> result = new ArrayList<>();
        for(int i=0 ;i<=25 ;i++){
            indexList.add(0);
        }
        Set<Character> characterSet = new HashSet<>(40);
        for (int i = 0 ;i<S.length();i++){
            char c = S.charAt(i);
            if(!characterSet.contains(c)){
                int lastIndex = S.lastIndexOf(c);
                indexList.set(c-97,lastIndex);
                characterSet.add(c);
            }
        }
        int pre = 0;
        int max = 0;
        for (int i = 0 ;i<S.length();i++){
            char c = S.charAt(i);
            int maxIndex = indexList.get(c-97);
            if(maxIndex > max){
                max = maxIndex;
            }
            if(i==max) {
                result.add(i-pre+1);
                pre = i+1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println((int) 'a');
        String S = "abcah";
        List<Integer> list =  new S763().partitionLabels(S);
       list.forEach(System.out::println);
    }
}
