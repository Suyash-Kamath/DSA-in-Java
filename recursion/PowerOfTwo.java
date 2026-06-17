public class PowerOfTwo {
    
    static int helper(int n){
        
        if (n==0){
            return 1;
        }
        
      
        
      return 2 *  helper(n-1);
        
    }
    
    
    public static void main(String[] args) {
        int n=5;
        
      int ans =  helper(n);
      
      System.out.println(ans);
    }
}
