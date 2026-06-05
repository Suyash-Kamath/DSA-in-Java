// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class singleNonDuplicateElement {
    
    static int singleNumberInDuplicate(int []arr){
        int n = arr.length;
        
        int start =0;
        int end = n-1;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            // single element 
            
            if(start==end){
                return arr[start];
            }
            
            // Non single element , 
            // check whether mid element is ans or not 
            
            int currentValue = arr[mid];
            int previousValue = -1;
            
            if(mid-1>=0){
                previousValue = arr[mid-1];
                
            }
            int nextValue = -1;
            if(mid+1<n){
                nextValue=arr[mid+1];
            }
            
            if(currentValue!=previousValue && currentValue!=nextValue){
                // current value is valid ans ;
                return currentValue ;
            }
            
            if(currentValue!=previousValue && currentValue==nextValue){
                int startIndexOfPair = mid;
                
                if((startIndexOfPair & 1)==1){
                    end =mid-1;
                }else{
                    // satrt index even case
                    start = mid+1;
                }
            }
            else  if(currentValue==previousValue && currentValue!=nextValue){
                int endIndexOfPair = mid;
                
                if((endIndexOfPair & 1)==1){
                    start = mid+1;
                }else{
                    // satrt index even case
                    end = mid-1;
                }
            }
        }
        return -1;
        
    }
    public static void main(String[] args) {
        int []arr = {1,1,2,3,3,4,4,8,8};
        
       int ans = singleNumberInDuplicate(arr);
       System.out.println(ans);
    }
}
