public class CoinChangeII {
    static int solve(int amount,int []coins,int index){

        if(amount ==0 ){
            return 1;
        }

        if (amount<0){
            return 0;
        }
        // saare koi khatam and amount ko 0 nahi pocha paaya
        if(index>=coins.length){
            return 0;
        }

        // ek case we will solve , rest recursion will handle
        // maanlo coin value 5 and amount is 40
        // remaining coin is 35 , and coin ko dobara use kar sakta toh , aage badaane ki need nahi hai 
        int includeAns = solve(amount-coins[index], coins,index);
        // amount = 40 and current coin ko use nahi kiya
        // means amount me koi change nahi hua 
        // but kyuki main current coin ko clude kar raha hu , toh mujhe next coin par move krna padega
        int excludeAns = solve(amount, coins,index+1);

        int finalAns = excludeAns+includeAns;
        return finalAns ;


    }
    static int change(int amount,int []coins){
        int index =0;
        int ans =solve(amount,coins,index);
        return ans ;

    }
    public static void main(String[] args) {
        int amount = 5;
        int []coins = {1,2,5};
        int answer = change(amount,coins);
        System.out.println(answer);
    }
}
