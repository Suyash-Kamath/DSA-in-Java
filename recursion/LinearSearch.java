public class LinearSearch {

    static boolean linearSearch(int []arr,int n, int index, int target){
        
        if(index ==n){
            return false;
        }
        if(arr[index]==target){
            return true;
        }
        index++;
        return linearSearch(arr, n, index, target);
    }
    public static void main(String[] args) {
        int []arr = {10,20,30,40,50,60,70};
        int n = arr.length;
        int index = 0;
        int target = 710;
        boolean ans = linearSearch(arr,n,index,target);
        if(ans) System.out.println("Answer is Present");
        else System.out.println("Answer is not present");
    }
}
