public class MinElement {

    static int findMin(int []arr,int n,int mini,int index){
        if(index==n){
            return mini ;
        }
        if(arr[index]<mini){
            mini = arr[index];
            
        }
        index++;
        return findMin(arr, n, mini, index);

    }
    public static void main(String[] args) {
        int []arr = {10,20,130,40,50,60,100};
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        int index=0;
        int minElement = findMin(arr,n,mini,index);
        System.out.println(minElement);
    }
}
