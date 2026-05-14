public class RotateImage {

    static void  rotateClockwise(int [][]matrix,int N){
        // T.C is O(N^2)+O(N^2)

        // Transpose of a Matrix
        for(int i =0;i<N;i++){
            for(int j = i+1;j<N;j++){
                // swap(matrix[i][j],matrix[j][i])

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Row Reverse

        for(int row =0 ;row<N;row++){
            // came into new row and not start swapping 

            int startCol =0;
            int endCol = N-1;

            while(startCol <= endCol){
                int temp = matrix[row][startCol];
                matrix[row][startCol] = matrix[row][endCol];
                matrix[row][endCol] = temp;


                startCol++;
                endCol --;
            }
        }

        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int [][]arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        int N = 3;
        rotateClockwise(arr,N);
    }
}
