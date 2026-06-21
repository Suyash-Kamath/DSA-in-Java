public class MaxElement {

    static int findMax(int []arr,int n,int maxi,int index){
        if(index==n){
            return maxi ;
        }
        if(arr[index]>maxi){
            maxi = arr[index];
            
        }
        index++;
        return findMax(arr, n, maxi, index);

    }
    public static void main(String[] args) {
        int []arr = {10,20,130,40,50,60,100};
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int index=0;
        int maxElement = findMax(arr,n,maxi,index);
        System.out.println(maxElement);
    }
}
