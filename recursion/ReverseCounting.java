
public class ReverseCounting {
    static void counter(int count,int limit){
        if(count<limit){
            return ;
        }
        System.out.println(count);
        counter(count-1,limit);
        
    }
    public static void main(String[] args) {
      int limit = 1;
      int count = 10;
      counter(count,limit);
    }
}
