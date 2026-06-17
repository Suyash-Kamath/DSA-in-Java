
public class Counting {
    static void counter(int count,int limit){
        if(count>limit){
            return ;
        }
        System.out.println(count);
        counter(count+1,limit);
        
    }
    public static void main(String[] args) {
      int limit = 10;
      int count = 1;
      counter(count,limit);
    }
}
