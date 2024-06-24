package org.lzw;

import java.util.Arrays;

public class Date0624 {
    public static void main(String[] args) {
        int[] ints = new Date0624().nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        System.out.println(Arrays.toString(ints));

    }

    //下一个更大的元素

    /*//解法1：暴力解
    public int[] nextGreaterElements(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                ans[i] = -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) continue;
            int j = i + 1;
            while (true) {
                int k = j >= nums.length ? j - nums.length : j;
                if (nums[i] >= nums[k]) j++;
                else {
                    ans[i] = nums[k];
                    break;
                }
            }

        }
        return ans;
    }*/

    //解法2：反向跳解
    public int[] nextGreaterElements(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                ans[i] = -1;
                index = i;
            }
        }
        for (int i = index, count = 0; ; ) {
            if (nums[i] != max) {
                int j = i + 1;
                while (true) {
                    int k = j >= nums.length ? j - nums.length : j;
                    if (nums[k] == max) {
                        ans[i] = k;
                        break;
                    } else if (nums[i] >= nums[k]) {
                        j = ans[k];
                    } else {
                        ans[i] = k;
                        break;
                    }
                }
            }
            i--;
            count++;
            if (count == nums.length) break;
            if (i < 0) i = nums.length - 1;
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != -1) ans[i] = nums[ans[i]];
        }
        return ans;
    }

    /*//解法3：单调栈 https://leetcode.cn/problems/next-greater-element-ii/?envType=daily-question&envId=2024-06-24
       public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }*/
}
