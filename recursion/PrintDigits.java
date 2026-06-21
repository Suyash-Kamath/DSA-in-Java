public class PrintDigits {

    static void printDigits(int n){

        if(n==0) return;
        printDigits(n/10);
        System.out.println(n%10);
        
    }
    
    public static void main(String[] args) {
        int n=137;
        printDigits(n);
    }
}
