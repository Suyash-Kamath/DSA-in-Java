public class BinarySearch {

    static boolean binarySearch(int []arr,int target,int start,int end){
        if(start>end){
            return false;
        }

        int mid = start+(end-start)/2;
        if(arr[mid]==target){
            return true;
        }
        else if(arr[mid]>target){
            end = mid-1;
        }else{
            start = mid+1;
        }

        return binarySearch(arr, target, start, end);
    }
    public static void main(String[] args) {
        int []arr = {10,20,30,40,50,60,70,80};
        int target = 80;
        int start = 0;
        int end = arr.length-1;
        boolean answer = binarySearch(arr,target,start,end);
        if(answer){
            System.out.println("Target element is present");
        }
        else{
            System.out.println("Target Element is Absent");
        }
    }
    
}