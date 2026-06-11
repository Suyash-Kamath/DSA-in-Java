public class RowWithMaximumOnes{
    static int firstOccurrence(int [][]matrix,int rowIndex){
        int totalRow = matrix.length;
        int totalColumn = matrix[0].length;
        int target = 1;
        int ans =-1;
        // handling case where there is no 1 inside the row 
        // sorted array hai , rightmost element dekho naa
        if(matrix[rowIndex][totalColumn-1]==0){
            // count = total col - first element ka index
            // count =0 , total col me se first index minus karenge , means first index ko m karna padega , so m-m is 0
            
            return totalColumn;
        }else{
            int s=0;
            int e = totalColumn-1;
            while(s<=e){
                int mid = s +(e-s)/2;
                if(matrix[rowIndex][mid]==0){
                    s = mid+1;
                }else{
                    ans = mid;
                    e = mid-1;
                }
            }
        }
        return ans;
    }
    static int rowWithMaxOnes(int [][]matrix){
        // move to each row and for each row find the first occurrence and using the first occurrence calculate count of 1, update the maxi variable or the ans index variable on the basis of that
         int totalRow = matrix.length;
        int totalColumn = matrix[0].length;
        int maxi =-1;
        int maxOneValiIndex =-1;
        
        for(int row =0;row<totalRow;row++){
            // for each row find the first occurence
            
            int firstOccurrenceIndex = firstOccurrence(matrix,row);
            // calculate number of 1s in this row 
            
            int oneCount = totalColumn - firstOccurrenceIndex;
            // update maxi or ans index variable basis on count
            if(oneCount!=0 && oneCount>maxi){
                // ho sakta hai current row hi ans ho 
                maxi = oneCount;
                maxOneValiIndex = row;
                
            }
            
        }
        
        return maxOneValiIndex;
    }
    public static void main(String []args){
        int[][] matrix = {
            {0,0,0,1},
            {0,0,1,1},
            {0,1,1,1},
            {1,1,1,1}
        };
        
        int answer = rowWithMaxOnes(matrix);
        System.out.println(answer);
    }
}
