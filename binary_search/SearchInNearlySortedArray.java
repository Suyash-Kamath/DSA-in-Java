public class SearchInNearlySortedArray {

    static int search(int []arr,int target,int n){
        int start =0;


        int end = n-1;


        while (start<=end) {

            int mid = start+(end-start)/2;

            if(arr[mid]==target) return mid;

            if(mid-1 >=0&& arr[mid-1]==target) return mid-1;

            if(mid+1<n && arr[mid+1]==target) return mid+1;

            if(target>arr[mid]){
                start = mid+2;
            }else{
                end = mid-2;
            }


            
        }

        return -1;
    }
   public static void main(String[] args) {
    int []arr = {3,5,10,9,11};
    int n=5;
    int K=10;
    int ans = search(arr,K,n);

    System.out.println(ans);
   } 
}
