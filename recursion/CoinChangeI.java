public class CoinChangeI {
   static int solve(int[]coins,int amount){
        // base case

        if (amount==0){
            return 0;
        }
        if (amount<0){
            // invalid case
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;
        // amount ke liye saare coins ko try karunga , trying each and every possible combination to find the min coinc count

        for(int coin:coins){
            int recursionAns = solve(coins,amount-coin); // this stores recursion ka answer
            // invalid case 
            if (recursionAns!=Integer.MAX_VALUE){

            int totalCoinsUsed = recursionAns+1;
            mini=Math.min(mini,totalCoinsUsed);

            }

        }
        return mini;
    }
    static int coinChange(int[] coins, int amount) {
       
        int ans =  solve(coins,amount);

        if(ans==Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }

    public static void main(String[] args) {
        int []coins = {1,2,5};
        int amount=1;
        int answer = coinChange(coins,amount);
        System.out.println(answer);

    }
}
