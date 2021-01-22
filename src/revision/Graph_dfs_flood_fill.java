package revision;
//https://leetcode.com/problems/flood-fill/
public class Graph_dfs_flood_fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][]visited = new boolean[image.length][image[0].length];
        floodFill(image, visited, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void floodFill(int[][] image, boolean[][]visited, int i, int j, int newColor, int oldColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || visited[i][j] || image[i][j] != oldColor) {
            return;
        }
        visited[i][j] = true;
        floodFill(image, visited, i - 1, j, newColor, oldColor);
        floodFill(image, visited, i + 1, j, newColor, oldColor);
        floodFill(image, visited, i, j - 1, newColor, oldColor);
        floodFill(image, visited, i, j + 1, newColor, oldColor);
        image[i][j] = newColor;
    }
}
