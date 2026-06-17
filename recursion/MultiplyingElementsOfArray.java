
public class MultiplyingElementsOfArray{
    
    
    static int helper(int []arr,int size,int mul,int index){
        
        if(index ==size){
            return mul;
        }
        
        mul*=arr[index];
       return  helper(arr,size,mul,index+1);
        
      
        
        
    }
    
    public static void main(String []args){
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        int size = arr.length;
        int mul =1;
        int index =0;
        
        int ans = helper(arr,size,mul,index);
        System.out.println(ans);
        
    }
    
    
}
