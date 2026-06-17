// 0 1 1 2 3 5 8 13

// every number is sum of pichla 2 element


public class FibonacciNumber {
    
    static int helper(int n){
        
        if (n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        
        
        
      
       int ans = helper(n-1)+helper(n-2);
       
       return ans;
    
        
    }
    
    
    public static void main(String[] args) {
        int n=5;
        
      int ans =  helper(n);
      
      System.out.println(ans);
    }
}
