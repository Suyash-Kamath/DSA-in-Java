import java.util.Scanner;

public class BinarySearch {

    static boolean binarySearch(int []arr,int target){
        
        int start =0;
        int end = arr.length-1;

        while (start<=end) {
            // int mid = (start+end)/2;
            int mid = (start + (end-start)/2);

            if(arr[mid]==target){
                return true;
            }

            if(target>arr[mid]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
            
        }

        return false;




       
    }
    public static void main(String[] args) {
        int []arr = {1,2,3,8,9,12,15,16,17};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Target Value");
        int target =sc.nextInt();
        sc.close();
        boolean answer = binarySearch(arr,target);
        
        if(answer){
            System.out.println("Target is present ");
        }else{
            System.out.println("Target is not present");
        }
    }
}
