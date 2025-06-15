//Time complexity - O(m*n)
//Space complexity - O(m*n)
// solved on leetcode - yes
// Did you faced any issues - No
//The algorithm starts by storing the original color and using a queue to perform a Breadth-First Search (BFS) from the starting cell. It replaces the starting pixel's color and iteratively checks its 4-connected neighbors (up, down, left, right); if a neighbor has the original color, it is recolored and added to the queue. This continues until all connected pixels with the original color are updated to the new color.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        int rows = image.length, cols = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0], col = current[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = color;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }
}
