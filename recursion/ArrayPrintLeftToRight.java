// Array of integer, print using recursion



public class ArrayPrintLeftToRight{
    
    static void helper(int []arr,int i,int size){
        if(i==size){
            return ;
        }
        System.out.println(arr[i]);
        i++;
        helper(arr,i,size);
        
        
    }
    
    public static void main(String[]args){
        
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        int i=0;
        int size = arr.length;
        
        helper(arr,i,size);
        
    }
    
}
