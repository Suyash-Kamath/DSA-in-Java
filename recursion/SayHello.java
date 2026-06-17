public class SayHello {
    
    static void helper(int n){
        
        if (n==0){
            return;
        }
        
        System.out.println("Hello");
        
        helper(n-1);
        
    }
    
    
    public static void main(String[] args) {
        int n=5;
       helper(n);
    }
}
