public class NumberOfOccurrence {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 3, 4, 5};

        int target = 2;

        int result = numberOfOccurrence(arr, target);

        System.out.println(result);
    }

    static int numberOfOccurrence(int[] arr, int target) {

        int lb = lowerBound(arr, target);

        // target not found
        if (lb == arr.length || arr[lb] != target) {
            return 0;
        }

        int ub = upperBound(arr, target);

        return ub - lb;
    }

    static int lowerBound(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        int ans = arr.length;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {

                ans = mid;

                end = mid - 1;

            } else {

                start = mid + 1;
            }
        }

        return ans;
    }

    static int upperBound(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        int ans = arr.length;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {

                ans = mid;

                end = mid - 1;

            } else {

                start = mid + 1;
            }
        }

        return ans;
    }
}