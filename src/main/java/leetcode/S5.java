package leetcode;

public class S5 {
    public String longestPalindrome(String s) {
/*        if(s.isEmpty()){
            return "";
        }*/
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        int[] r = new int[s.length()*2+2];
        for(int i = 0 ; i<s.length();i++){
            stringBuilder.append(s.charAt(i)).append("#");
        }
        r[0] =1;
        int i = 1;
        int rightMax = 1;
        int resultIndex = 0;
        int resultR = 1;
        for(int j = 1 ; j<stringBuilder.length();j++){
            if (j < rightMax)
                r[j] = Math.min(r[2 * i - j], rightMax - j);
            else
                r[j] = 1;
            while ((j - r[j])>=0&&(j + r[j])<stringBuilder.length()&&stringBuilder.charAt(j - r[j]) == stringBuilder.charAt(j + r[j])){
                r[j]++;
            }

            if (rightMax < j + r[j]) {
                i = j;
                rightMax = j + r[j];
            }
            if(r[j]>resultR){
                resultIndex = j;
                resultR = r[j];
            }
        }
        String s1 = stringBuilder.substring(resultIndex-resultR+1,resultIndex+resultR);
        return  s1.replaceAll("#","");

    }

    public static void main(String[] args){
        String s="";
        System.out.println(new S5().longestPalindrome(s));
    }
}
