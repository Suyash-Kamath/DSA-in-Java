public class UpperBound {
    public static void main(String[] args) {
        int []arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int result = upperBound(arr, target);
        System.out.println(result);
    }

    static int upperBound(int []arr, int target){
        int start =0;
        int end = arr.length-1;

        int ans =-1;

        while(start<= end){
            int mid = start + (end-start)/2;
            if(arr[mid]>target){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}