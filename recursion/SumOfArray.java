// Mistakes which I did 

/*

Mistake 1: You are ignoring the recursive return value

You wrote:

helper(arr, size, sum, index + 1);

return sum;

Let's see what happens.

Suppose the array is:

{1,2,3}

Execution:

helper(0, sum=0)
    sum = 1
    helper(1, sum=1)
        sum = 3
        helper(2, sum=3)
            sum = 6
            helper(3, sum=6)
                return arr[2] = 3
        return 3
    return 1

Notice something?

Every recursive call throws away the value returned by the deeper call.

You never do:

return helper(...);

Instead you simply call it and ignore its answer.

Mistake 2: Your base case is incorrect

You wrote:

if(index == size){
    return arr[index-1];
}

Ask yourself:

What should be returned when I've already processed every element?

At that point, nothing is left to add.

So the answer should be:

return sum;

or, if you're not carrying sum,

return 0;

Returning the last element again makes no logical sense because you've already added it.

*/



public class SumOfArray{
    
    
    static int helper(int []arr,int size,int sum,int index){
        
        if(index ==size){
            return sum;
        }
        
        sum+=arr[index];
       return  helper(arr,size,sum,index+1);
        
      
        
        
    }
    
    public static void main(String []args){
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        int size = arr.length;
        int sum =0;
        int index =0;
        
        int ans = helper(arr,size,sum,index);
        System.out.println(ans);
        
    }
    
    
}
