package org.lzw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//2741 未通过时间要求
public class Date0626 {
    public static void main(String[] args) {
        Date0626 date0626 = new Date0626();
        int ans = date0626.specialPerm(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192});
//        int ans = date0626.specialPerm(new int[]{2, 3, 6});
        System.out.println(ans);
    }

    Long count;

    //判断，分裂，判断
    public int specialPerm(int[] nums) {
        count = 0L;
        int[] ints = new int[nums.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 1;
            int len = 1;
            int left = nums[i];
            DFS(left, len, ints, nums);
            ints[i] = 0;
        }
        return (int) (count % (1000000000 + 7));
    }

    private void DFS(int left, int len, int[] ints, int[] nums) {
        if (len == nums.length) {
            count++;
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) continue;
            int ans1 = left % nums[i];
            int ans2 = nums[i] % left;
            if (ans1 == 0 || ans2 == 0) {
                ints[i] = 1;
                DFS(nums[i], len + 1, ints, nums);
                ints[i] = 0;
            }
        }

    }
}
