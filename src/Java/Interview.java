package Java;

import java.util.*;

public class Interview {

    public static void main(String[] args) {
        int[][] arr={{1,8,6,9},{0,7,8,4},{2,2,1,0},{21,7,5,4}};
        int n = arr.length;
        int count =0;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int  j =0;j < n;j++){
               Set<Integer> val =  map.getOrDefault(arr[i][j], new HashSet<>());

               if(!val.add(i+1)){
                   count++;
               }
               map.put(arr[i][j], val);
            }
        }

        System.out.println(map);
        System.out.println(count);
    }
}
