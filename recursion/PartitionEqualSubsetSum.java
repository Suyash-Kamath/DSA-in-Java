public class PartitionEqualSubsetSum{
    
    static boolean solve(int target,int []nums,int index){
        if (target==0){
            return true;
        }
        
        if (target<0){
            return false;
        }
        
        if (index>=nums.length){
            return false;
        }
        
        
        // include
        
        boolean includeAns = solve(target-nums[index],nums,index+1);
         boolean excludeAns = solve(target,nums,index+1);
         
         return includeAns || excludeAns;
        
    }
    static boolean canPartition(int []nums){
        int sum =0;
        for(int num:nums){
            sum+=num;
        }

        if((sum&1)==1) return false;
        
        int index =0;
        int target = sum/2;
        boolean ans = solve(target,nums,index);
        return ans ;
        
    }
    public static void main(String []args){
        int []nums={1,5,11,5};
        boolean ans = canPartition(nums);
        if (ans){
            System.out.println("Yes arrays can be partitioned");
        }
        else{
             System.out.println("Yes arrays cannot  be partitioned");
        }
        
    }
}
