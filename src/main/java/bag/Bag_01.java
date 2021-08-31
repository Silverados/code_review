package bag;

import java.util.Arrays;

public class Bag_01 {
    // 有N件物品和容量为V的背包。放入第i件费用是Ci, 得到的价值是Wi。求解将哪些物品装入背包可以使价值总和最大
    public static void main(String[] args) {
        System.out.println(getSolution(3, 5, new int[]{1, 2, 3}, new int[]{1, 3, 2}));
    }

    // 假设数据合理
    public static int getSolution(int N, int V, int[] C, int[] W) {
        int[][] helper = new int[N + 1][V + 1];

        // 第一版
        for (int i = 1; i <= N; i++) {
            for (int v = 1; v <= V; v++) {
                helper[i][v] = Math.max(helper[i - 1][v], v - C[i - 1] >= 0 ? helper[i - 1][v - C[i - 1]] + W[i - 1] : 0);
            }
        }

//        // 时间复杂度优化
//        for (int i = 1; i <= N; i++) {
//            for (int v = C[i - 1]; v <= V; v++) {
//                helper[i][v] = Math.max(helper[i - 1][v], helper[i - 1][v - C[i - 1]] + W[i - 1]);
//            }
//        }

        System.out.println(Arrays.deepToString(helper));
        return helper[helper.length - 1][helper[0].length - 1];
    }

    // 空间复杂度优化
    public static int getSolution1(int N, int V, int[] C, int[] W) {
        int[] helper = new int[V + 1];

        for (int i = 1; i <= N; i++) {
            for (int v = V; v >= C[i]; v--) {
                helper[v] = Math.max(helper[v], helper[v - C[i - 1]] + W[i - 1]);
            }
        }


        System.out.println(Arrays.toString(helper));
        return helper[helper.length - 1];
    }


    // 如果要求背包刚好填满， 初始化数组方式不一样
    public static int getSolution2(int N, int V, int[] C, int[] W) {
        int[] helper = new int[V + 1];

        helper[0] = 0;
        for (int i = 1; i < helper.length; i++) {
            helper[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            for (int v = V; v >= C[i]; v--) {
                helper[v] = Math.max(helper[v], helper[v - C[i - 1]] + W[i - 1]);
            }
        }


        System.out.println(Arrays.toString(helper));
        return helper[helper.length - 1];
    }
}
