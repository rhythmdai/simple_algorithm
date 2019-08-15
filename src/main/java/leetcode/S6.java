package leetcode;

public class S6 {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int len = s.length();
        int rowMax = numRows;
        int num = len/(numRows*2-2)+1;
        int colMax = num*(numRows-1);
        char[][] matrix = new char[rowMax][colMax];
        int index = 0;
        int col = 0;
        int row = 0;
        for(int i=1;i<=num;i++){
            if(index==s.length()){
                break;
            }
            for(int j=0;j<numRows;j++){
                if(index==s.length()){
                    break;
                }
                matrix[row][col] = s.charAt(index++);
                row++;
            }
            row--;
            for(int j = 0 ; j< numRows-2 ; j++){
                row--;
                col++;
                if(index==s.length()){
                    break;
                }
                matrix[row][col] = s.charAt(index++);
            }
            row--;
            col++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0 ;i<numRows;i++){
            for (int j = 0 ; j<colMax;j++){
                if(matrix[i][j]!=0){
                    stringBuilder.append(matrix[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        System.out.println(new S6().convert("PAPAPAPAP",2));
    }
}

