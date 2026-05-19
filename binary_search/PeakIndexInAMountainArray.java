public class PeakIndexInAMountainArray {

    static int peakIndexInAMountainArray(int []arr){
       
        int start =0;
        int end = arr.length-1;
        int index =-1;
        while (start<=end) {
            int mid = start + (end-start)/2;

            if(arr[mid]>=arr[mid+1]){
                index = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
            
        }

        return index;
    }
    public static void main(String[] args) {
        int []arr = {0,2,5,3,1};
        int index = peakIndexInAMountainArray(arr);
        System.out.println(index);
    }
}
