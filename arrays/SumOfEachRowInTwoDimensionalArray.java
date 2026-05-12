import java.util.List;
import java.util.ArrayList;

public class SumOfEachRowInTwoDimensionalArray {

    static List<Integer> rowSum(int [][]arr){
        List<Integer>result = new ArrayList<>();

        int n = arr.length;
        int m = arr[0].length;
        
        int sum =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=arr[i][j];
            }
            result.add(sum);
            sum=0;
        }

        return result;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer>result = rowSum(arr);
        System.out.println(result);
    }
}
