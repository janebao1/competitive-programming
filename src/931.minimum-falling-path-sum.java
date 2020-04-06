/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 *
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 *
 * algorithms
 * Medium (60.11%)
 * Likes:    516
 * Dislikes: 50
 * Total Accepted:    38K
 * Total Submissions: 62.2K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a square array of integers A, we want the minimum sum of a falling
 * path through A.
 * 
 * A falling path starts at any element in the first row, and chooses one
 * element from each row.  The next row's choice must be in a column that is
 * different from the previous row's column by at most one.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation: 
 * The possible falling paths are:
 * 
 * 
 * 
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * 
 * 
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 * 
 */

// @lc code=start
class Solution {

    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        if (m == 0) {
            return 0;
        }
        int n = A[0].length;
        if (m == 1) {
            int minFallingPathSum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                minFallingPathSum = Math.min(minFallingPathSum, A[0][i]);
            }
            return minFallingPathSum;
        }

        int minFallingPathSum = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minPath = A[i-1][j];
                if (j != 0) {
                    minPath = Math.min(minPath, A[i-1][j-1]);
                }
                if (j != n-1) {
                    minPath = Math.min(minPath, A[i-1][j+1]);
                }
                A[i][j] += minPath;
                if (i == m-1) {
                    minFallingPathSum = Math.min(minFallingPathSum, A[i][j]);
                }
            }
        }

        return minFallingPathSum;
    }

}
// @lc code=end
