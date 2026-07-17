import java.util.ArrayList;
import java.util.Collections;

public class RatInMaze {

    static boolean isSafeToMove(int newX, int newY, int n, int[][] maze, boolean[][] visited) {

        // out of bound
        if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
            return false;
        }
        // blocked cell
        else if (maze[newX][newY] == 0) {
            return false;
        }
        // already visited
        else if (visited[newX][newY] == true) {
            return false;
        } else {
            return true;
        }
    }

    static void solve(int[][] maze, int srcX, int srcY, int destX, int destY,
                       boolean[][] visited, ArrayList<String> ans, String path) {

        if (srcX == destX && srcY == destY) {
            ans.add(path);
            return;
        }
        visited[srcX][srcY] = true;
        int n = maze.length;

        // 4 movements

        // Up
        int newX = srcX - 1;
        int newY = srcY;
        if (isSafeToMove(newX, newY, n, maze, visited)) {
            solve(maze, newX, newY, destX, destY, visited, ans, path + "U");
        }

        // Down
        newX = srcX + 1;
        newY = srcY;
        if (isSafeToMove(newX, newY, n, maze, visited)) {
            solve(maze, newX, newY, destX, destY, visited, ans, path + "D");
        }

        // Left
        newX = srcX;
        newY = srcY - 1;
        if (isSafeToMove(newX, newY, n, maze, visited)) {
            solve(maze, newX, newY, destX, destY, visited, ans, path + "L");
        }

        // Right
        newX = srcX;
        newY = srcY + 1;
        if (isSafeToMove(newX, newY, n, maze, visited)) {
            solve(maze, newX, newY, destX, destY, visited, ans, path + "R");
        }

        // backtrack: undo visited so other paths can use this cell
        visited[srcX][srcY] = false;
    }

    static ArrayList<String> ratInMaze(int[][] maze) {

        int srcX = 0;
        int srcY = 0;
        int n = maze.length;
        int destX = n - 1;
        int destY = n - 1;

        boolean[][] visited = new boolean[n][n];
        ArrayList<String> ans = new ArrayList<>();
        String path = "";

        // if src or destination is blocked
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }
        solve(maze, srcX, srcY, destX, destY, visited, ans, path);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        ArrayList<String> paths = ratInMaze(maze);
        System.out.println(paths.isEmpty() ? "No path found" : paths);
    }
}
