public class ArrayPrintRightToLeft{
    static void helper(int []arr,int size,int index){
        
        if(index <0){
            return;
        }
        
        System.out.println(arr[index]);
        helper(arr,size,index-1);
        
    }
    public static void main(String []args){
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        int size = arr.length;
        int index = size-1;
        helper(arr,size,index);
        
    }
}
