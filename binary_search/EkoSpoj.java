public class EkoSpoj {

    static boolean isValid(int mid, int[] trees, int m) {
        long woodCollected = 0;

        for (int i = 0; i < trees.length; i++) {
            if (trees[i] > mid) {
                woodCollected += trees[i] - mid;
            }

            if (woodCollected >= m) {
                return true;
            }
        }

        return false;
    }

    static int maxSawHeight(int[] trees, int m) {
        int start = 0;
        int end = 0;
        int ans = -1;

        for (int tree : trees) {
            end = Math.max(end, tree);
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(mid, trees, m)) {
                ans = mid;
                start = mid + 1; // try bigger saw height
            } else {
                end = mid - 1; // reduce saw height
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {20, 15, 10, 17};
        int m = 7;

        int ans = maxSawHeight(arr, m);
        System.out.println(ans); // 15
    }
}