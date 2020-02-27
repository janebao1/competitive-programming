/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 *
 * https://leetcode.com/problems/swim-in-rising-water/description/
 *
 * algorithms
 * Hard (50.04%)
 * Likes:    444
 * Dislikes: 38
 * Total Accepted:    18.9K
 * Total Submissions: 37.4K
 * Testcase Example:  '[[0,2],[1,3]]'
 *
 * On an N x N grid, each square grid[i][j] represents the elevation at that
 * point (i,j).
 * 
 * Now rain starts to fall. At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square if and
 * only if the elevation of both squares individually are at most t. You can
 * swim infinite distance in zero time. Of course, you must stay within the
 * boundaries of the grid during your swim.
 * 
 * You start at the top left square (0, 0). What is the least time until you
 * can reach the bottom right square (N-1, N-1)?
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have
 * a higher elevation than t = 0.
 * 
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 * ⁠0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * 
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= N <= 50.
 * grid[i][j] is a permutation of [0, ..., N*N - 1].
 * 
 * 
 */

import java.util.PriorityQueue;

// @lc code=start
class Solution {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];
        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Cell(0, 0, grid[0][0]));
        int[] x = {-1, 0, 0, 1};
        int[] y = {0, -1, 1, 0};

        while (true) {
            Cell cell = priorityQueue.poll();
            if (cell.i == n-1 && cell.j == n-1) {
                return cell.elevation;
            }
            for (int i = 0; i < 4; i++) {
                int tempX = cell.i + x[i];
                int tempY = cell.j + y[i];
                if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n && !isVisited[tempX][tempY]) {
                    isVisited[tempX][tempY] = true;
                    priorityQueue.add(new Cell(tempX, tempY, Math.max(grid[tempX][tempY], cell.elevation)));
                }
            }
        }
    }

    private static class Cell implements Comparable<Cell> {
        public int i;
        public int j;
        public int elevation;
        public Cell(int i, int j, int elevation) {
            this.i = i;
            this.j = j;
            this.elevation = elevation;
        }
        @Override
        public int compareTo(Cell cell) {
            return this.elevation - cell.elevation;
        }
    }

}
// @lc code=end
