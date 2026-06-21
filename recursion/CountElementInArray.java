public class CountElementInArray {

    static int countElement(int []arr,int n, int element , int count,int index){
        if(index==n)return count;

        if(arr[index]==element){
            count++;
        }
        index++;
        int ans = countElement(arr, n, element, count, index);
        return ans ;

    }
    public static void main(String[] args) {
        int []arr = {10,20,10,10,40,50,10};
        int n = arr.length;
        int element = 10;
        int count=0;
        int index=0;
        int ans = countElement(arr,n,element,count,index);
        System.out.println(ans);

    }
}
