package leetcode;

public class S885 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        int max = Math.max(Math.max(c0, C - c0 - 1), Math.max(r0, R - r0 - 1));
        result[0][0] = r0;
        result[0][1] = c0;
        int index = 1;
        int r = r0;
        int c = c0;
        for (int i = 1; i <= max; i++) {
            c++;
            if (r >= 0 && r < R && c >= 0 && c < C) {
                result[index][0] = r;
                result[index][1] = c;
                index++;
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                r++;
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    result[index][0] = r;
                    result[index][1] = c;
                    index++;
                }
            }
            for (int j = 1; j <= 2 * i; j++) {
                c--;
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    result[index][0] = r;
                    result[index][1] = c;
                    index++;
                }
            }
            for (int j = 1; j <= 2 * i; j++) {
                r--;
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    result[index][0] = r;
                    result[index][1] = c;
                    index++;
                }
            }
            for (int j = 1; j <= 2 * i ; j++) {
                c++;
                if (r >= 0 && r < R && c >= 0 && c < C) {
                    result[index][0] = r;
                    result[index][1] = c;
                    index++;
                }
            }
            if (index == R * C) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new S885().spiralMatrixIII(5, 6, 1, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "," + result[i][1]);
        }
    }
}
