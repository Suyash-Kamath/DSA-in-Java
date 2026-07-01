
public class HouseRobber {
    
    static int solve(int []nums,int index){
        
        if(index>=nums.length){
            return 0; // means ghar hi nahi hai chori karne keliye 
        }
        
        // 1 case , baaki rec sambhalega
        
        // index wale house pe hu , 2 choice include ya fir exclude
        int includeAns=nums[index]+solve(nums,index+2);
        
        int excludeAns = 0+solve(nums,index+1);
        
        int finalAns = Math.max(includeAns,excludeAns);
        
        return finalAns;
    }
    
    static int rob(int []nums){
        int index=0;
       int ans = solve(nums,index);
       return ans ;
    }
    public static void main(String[] args) {
       int nums[] = {2,7,9,3,1};
       int ans = rob(nums);
       System.out.println(ans);
    }
}
