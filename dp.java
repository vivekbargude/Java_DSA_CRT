import java.util.*;

class GfG {

    static String dir = "DLRU";
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};

    // Check if a cell is valid (inside the maze and open)
    static boolean isValid(int r, int c, int n, int[][] maze) {
        return r >= 0 && c >= 0 && r < n && c < n && maze[r][c] == 1;
    }

    // Function to find all valid paths
    static void findPath(int r, int c, int[][] maze, String path,
                         ArrayList<String> res) {
        int n = maze.length;

        // If destination is reached, store the path
        if (r == n - 1 && c == n - 1) {
            res.add(path);
            return;
        }

        // Mark current cell as blocked
        maze[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (isValid(nr, nc, n, maze)) {
                findPath(nr, nc, maze, path + dir.charAt(i), res);
            }
        }

        // Unmark current cell
        maze[r][c] = 1;
    }

    // Function to find all paths and return them
    static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;
        String path = "";

        if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
            findPath(0, 0, maze, path, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        ArrayList<String> result = ratInMaze(maze);

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String p : result) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}

class Knapsack01 {

    public static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Fill the dp table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: 0 items or 0 capacity
                } else if (wt[i - 1] <= w) {
                    // Either include the item or don't
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    // Cannot include the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {10, 40, 50, 70};
        int W = 8;
        int n = wt.length;

        int maxValue = knapsack(wt, val, W, n);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }
}
\
class BackTracking {
    public static void main(String[] args){
        permute("ABC","");
    }

    public static void permute(String s, String ans) {
        if (s.isEmpty()) {
            System.out.println(ans);
            return;
        }

        int n = s.length();

        for (int i = 0; i < n; i++) {
            String ch = String.valueOf(s.charAt(i)); // or "" + s.charAt(i)
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            String rest = left + right;
            permute(rest, ans + ch);
        }
    }

}

import java.util.Arrays;

public class Arrayyysysy {
    public static void main(String[] args){
        int[] nums1 = {2,5};
        int[] nums2 = {3,4};
        long k = 2;
        long ans = kthSmallestProduct(nums1,nums2,k);
        System.out.println(ans);

    }

    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        long[] arr = new long[n1 * n2];
        int idx = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[idx] = (long) nums1[i] * (long) nums2[j];
                idx++;
            }
        }
        Arrays.sort(arr);

        // Since k is long, but array index must be int,
        // make sure k fits in int (if problem constraints allow)
        int l = (int)(k - 1);

        return arr[l];
    }

}



