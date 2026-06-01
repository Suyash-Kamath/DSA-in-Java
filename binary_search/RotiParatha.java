public class RotiParatha {

    static boolean isValid(int totalParatha, int cooks[], int totalCooks, int mid) {
        int parathaCount = 0;

        for (int i = 0; i < cooks.length; i++) {
            int currentCookRank = cooks[i];
            int j = 1;

            // For each cook, count how many parathas they can make within 'mid' time
            while (j * currentCookRank + (j - 1) * j / 2 * currentCookRank <= mid) {
                parathaCount++;
                j++;
            }

            if (parathaCount >= totalParatha) return true;
        }
        return false;
    }

    static int minTimeToCookPrata(int p, int[] cook, int n) {
        int ans = -1;
        int maxiRank = -1;

        for (int i = 0; i < cook.length; i++) {
            if (cook[i] > maxiRank) {
                maxiRank = cook[i];
            }
        }

        int s = 0;
        int e = maxiRank * ((n * (n + 1)) / 2);

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (isValid(p, cook, n, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int numberOfParathas = 10;
        int[] rank = {1, 2, 3, 4};
        int numberOfCooks = 4;

        int ans = minTimeToCookPrata(numberOfParathas, rank, numberOfCooks);
        System.out.println(ans); // Output: 6
    }
}