import java.util.*;

public class Triangle {

    static int solve(List<List<Integer>> triangle, int rowIndex, int colIndex) {

        // Base Case
        if (rowIndex == triangle.size() - 1) {
            return triangle.get(rowIndex).get(colIndex);
        }

        // Down
        int downAns = solve(triangle, rowIndex + 1, colIndex);

        // Diagonal
        int diagAns = solve(triangle, rowIndex + 1, colIndex + 1);

        // Include current cell in path sum
        int finalAns = triangle.get(rowIndex).get(colIndex)
                + Math.min(downAns, diagAns);

        return finalAns;
    }

    static int minimumTotal(List<List<Integer>> triangle) {
        return solve(triangle, 0, 0);
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int ans = minimumTotal(triangle);

        System.out.println(ans);
    }
}
