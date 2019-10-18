import java.util.*;

public class Solution {
    static int[] m1 = new int[] { 8, 1, 6, };
    static int[] m2 = new int[] { 3, 5, 7, };
    static int[] m3 = new int[] { 4, 9, 2, };
    static int[][] magic = new int[][]{ m1, m2, m3 };

    static int getDiff(int[][] arr) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count += Math.abs(arr[i][j] - magic[i][j]);
            }
        }

        return count;
    }

    static int[][] rotate(int[][] arr) {
        int[][] rotated = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rotated[i][j] = arr[j][2 - i];
            }
        }

        return rotated;
    }

    static int[][] reflect(int[][] arr) {
        int[][] reflected = new int[3][3];

        int firstColIndex = 0;
        int thirdColIndex = 2;

        for (int i = 0; i < 3; i++) {
            reflected[i][firstColIndex] = arr[i][thirdColIndex];
            reflected[i][thirdColIndex] = arr[i][firstColIndex];
            reflected[i][1] = arr[i][1];
        }

        return reflected;
    }

    static int[][] copy2D(int[][] source){
        int length = source.length;
        int[][] copy = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                copy[i][j] = source[i][j];
            }
        }

        return copy;
    }

    static int formingMagicSquare(int[][] s) {
        List<Integer> diffs = new ArrayList<>();

        int[][] c = copy2D(s);

        for (int reflectCount = 0; reflectCount < 2; reflectCount++) {
            diffs.add(getDiff(c));

            for (int rotateCount = 0; rotateCount < 3; rotateCount++) {
                c = rotate(c);
                diffs.add(getDiff(c));
            }

            c = reflect(c);
        }

        return Collections.min(diffs);
    }


    public static void main(String[] args) {

        int[] a7 = new int[] { 5, 3, 4, };
        int[] b7 = new int[] { 1, 5, 8, };
        int[] c7 = new int[] { 6, 4, 2, };
        int[][] arr7 = new int[][]{ a7, b7, c7 };

        int[] a1 = new int[] { 4, 9, 2, };
        int[] b1 = new int[] { 3, 5, 7, };
        int[] c1 = new int[] { 8, 1, 5, };
        int[][] arr1 = new int[][]{ a1, b1, c1 };

        int[] a14 = new int[] { 4, 5, 8, };
        int[] b14 = new int[] { 2, 4, 1, };
        int[] c14 = new int[] { 1, 9, 7, };
        int[][] arr14 = new int[][]{ a14, b14, c14 };

        System.out.println(formingMagicSquare(arr7));  // 7
        System.out.println(formingMagicSquare(arr1));  // 1
        System.out.println(formingMagicSquare(arr14)); // 14
    }
}
