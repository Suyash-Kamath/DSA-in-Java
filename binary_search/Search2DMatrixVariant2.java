

public class Search2DMatrixVariant2 {
    
    static boolean searchMatrix(int [][]matrix,int target){
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        
        int row=0;
        int col = totalCol - 1;
        
        
        while(row<totalRow && col >=0){
            if(matrix[row][col]==target){
                return true;
                
            }
            else if (matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [][]matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };
        int target = 13;
        
        boolean ans = searchMatrix(matrix,target);
        
        if (ans){
            System.out.println("Answer is present");
        }else{
             System.out.println("Answer is not  present");   
        }
    }
}
