//Time complexity - O(m*n)
//Space complexity - O(m*n)
// solved on leetcode - yes
// Did you faced any issues - No
// We start by adding all cells with value 0 to a queue and marking all 1s as unvisited by setting them to -1. Then, we perform a BFS starting from all 0s simultaneously, updating neighboring -1 cells with distance current + 1. This ensures that each cell gets filled with the shortest distance to the nearest 0 by expanding level by level from all 0s.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add all 0s to the queue and mark 1s as unvisited (-1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // mark unvisited
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: BFS from all 0s simultaneously
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];

                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] == -1) {
                    mat[r][c] = mat[cell[0]][cell[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}
