import java.util.List;
import java.util.ArrayList;

public class WavePrintMatrix {

    static List<Integer> wave(int [][]arr,int m, int n){
        List<Integer> result = new ArrayList<>();

        for(int col=0;col<n;col++){
            if(col%2==0){
                for(int row=0;row<m;row++){
                     result.add(arr[row][col]);
                }
            }else{
                for(int row = m-1;row>=0;row--){
                    result.add(arr[row][col]);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
         int [][]arr = {{1,2,3},{4,5,6},{7,8,9}};
         int m= 3;
         int n=3;

         List<Integer>result = wave(arr,m,n);
         System.out.println(result);
    }
    
}