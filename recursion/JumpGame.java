
public class JumpGame {
    
    static boolean solve(int []nums,int index){
        // base case
        // reached destination
        
        if(index ==nums.length-1) return true;
        if(index>=nums.length) return false;
        
        // aise block me khada hu jaha aage nahi jaa sakta
        
        if(nums[index]==0) return false;
        
        // ab 1 case solve, rest recursion , this is pattern of exploring all the combinations
        int jumpValue = nums[index];
        // jump value -> max jump possible from current position
        boolean overallAns = false;
        for (int jump = 1;jump <=jumpValue;jump++ ){
            
           boolean recAns = solve(nums,index+jump);
           overallAns = overallAns || recAns;
            
        }
        
        return overallAns ;
        
    }
    static boolean canJump(int []nums){
        int index =0;
        
        boolean ans =solve(nums,index);
        return ans ;
    }
    public static void main(String[] args) {
        int []nums = {2,3,1,1,4};
        boolean ans = canJump(nums);
        if (ans){
            System.out.println("Can Jump");
            
        }else{
            System.out.println("Cannot Jump");
        }
        
    }
}
