package leetcode;

public class S11 {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                int area = (j-i)*Math.min(height[i],height[j]);
                if(area>max){
                    max = area;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){

    }
}
