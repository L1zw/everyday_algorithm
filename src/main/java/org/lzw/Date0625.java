package org.lzw;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Date0625 {
    public static void main(String[] args) {
//        int[][] matrix = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 1, 1}};
        int[][] matrix = {{1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 0, 0, 1, 0}, {0, 0, 0, 0, 1}, {1, 0, 1, 1, 1}};
        System.out.println(new Date0625().goodSubsetofBinaryMatrix(matrix));
    }

 /*   public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> list = new ArrayList<Integer>();
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
            if (sum == 0) {
                list.add(i);
                return list;
            }
            if (sum == n) set.add(i);
        }
        for (int i = 0; i < m; i++) {
            if (set.contains(i)) continue;
            for (int j = i + 1; j < m; j++) {
                boolean wrongFlag = false;
                if (set.contains(j)) continue;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] + grid[j][k] > 1) {
                        wrongFlag = true;
                        break;
                    }
                }
                if (!wrongFlag) {
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return list;
    }*/

    /* public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
         List<Integer> list = new ArrayList<>();
         int m = grid.length;
         int n = grid[0].length;
         Set<Integer> set = new HashSet<>();

         for (int i = 0; i < m; i++) {
             int sum = 0;
             for (int j = 0; j < n; j++) {
                 sum += grid[i][j];
             }
             if (sum == 0) {
                 list.add(i);
                 return list;
             }
             if (sum == n) set.add(i);
         }
         for (int i = 0; i < m; i++) {
             if (set.contains(i)) continue;
             Set<Integer> allNums = IntStream.rangeClosed(i + 1, m - 1) // 生成m到n的流
                     .boxed()          // 将IntStream转换为Stream<Integer>
                     .filter(item -> !set.contains(item))
                     .collect(Collectors.toCollection(HashSet::new));
             for (int k = 0; k < n; k++) {
                 Iterator<Integer> iterator = allNums.iterator();
                 while (iterator.hasNext()) {
                     Integer next = iterator.next();
                     if (grid[i][k] + grid[next][k] > 1) {
                         iterator.remove();
                     }
                 }
                 if(allNums.size()==0)break;
             }
             Iterator<Integer> iterator = allNums.iterator();
             if (iterator.hasNext()) {
                 list.add(i);
                 list.add(iterator.next());
                 return list;
             }
         }
         return list;
     }*/
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                str.append(grid[i][j]);
            }
            if (sum == 0) {
                list.add(i);
                return list;
            }
            int key = Integer.parseInt(str.toString(), 2);
            if (!map.containsKey(key)) {
                map.put(key, i);
            }
        }
        List<Integer> collect = new ArrayList<>(map.keySet());
        for (int i = 0; i < collect.size(); i++) {
            Integer left = collect.get(i);
            for (int j = i + 1; j < collect.size(); j++) {
                Integer right = collect.get(j);
                if ((left & right) == 0) {
                    list.add(map.get(left));
                    list.add(map.get(right));
                    return list.stream().sorted().toList();
                }

            }
        }
        return list;
    }
}
