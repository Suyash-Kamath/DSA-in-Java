
public class MinimizeTheDifferenceBetweenTargetAndChosenElement {

    static int solve(int sum,int target,int[][]mat,int row){

        if(row>=mat.length){
            // sum is ready , calculate the diff between target and sum and store or return the min diff

            return Math.abs(target-sum);
        }

        int mini = Integer.MAX_VALUE ;

        // row index pe khada hu where multiple columns pe value padi and ahr ek column ko bar bar consider karunga and bar bar answer ka min leta rahunga

        for(int num:mat[row]){
           int ans = solve(sum+num, target, mat, row+1);
           mini = Math.min(mini,ans);
        }

        return mini;


    }

    static int minimizeTheDifference(int[][]mat,int target){

        int row =0;
        int sum =0;

        int ans =solve(sum,target,mat,row);
        return ans ;

    }

    public static void main(String[] args) {
        int [][]mat = {{1,2,3},{4,5,6},{7,8,9}};
        int target = 13;

        int ans = minimizeTheDifference(mat,target);
        System.out.println(ans);
    }
}