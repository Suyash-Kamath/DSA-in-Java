import java.util.ArrayList;
import java.util.List;

public class SumOfEachColumnInTwoDimensionalArray {

    static List<Integer> columnSum(int [][]arr){
        List<Integer> result = new ArrayList<>();

        int n = arr.length;
        int m = arr[0].length;


         int sum =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=arr[j][i];
            }
            result.add(sum);
            sum=0;
        }


        return result;
    }
    public static void main(String[] args) {
        int [][]arr = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result= columnSum(arr);
        System.out.println(result);
    }
}
