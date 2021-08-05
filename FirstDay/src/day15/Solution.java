package day15;

import java.lang.reflect.Array;
import java.security.spec.NamedParameterSpec;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "babab";
        int[][] arr = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[][] arr1 = new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k = 3;
        int[] ints = kWeakestRows(arr1, k);
        System.out.println(Arrays.toString(ints));
        System.out.println("hello hotfix");
    }

    /*
    [[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]]
    3
    [[1,0,0,0],
     [1,1,1,1],
     [1,0,0,0],
     [1,0,0,0]],
     */
    public static int[] kWeakestRows(int[][] mat, int k) {
        int len = mat[0].length;
        int length = mat.length;
        int[] karr = new int[length];
        int[] narr = new int[k];
        List<Integer> con = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if(mat[i][j] != 1){
                    break;
                }
                count++;
            }
            karr[i] = count;
            con.add(count);
        }
        Collections.sort(con);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < length; j++) {
                if(karr[j] == con.get(i)){
                    narr[i] = j;
                    karr[j] = -1;
                    break;
                }
            }
        }
        return narr;
    }
}




