public class ArrayProblemsI {

    static double getAverage(int[] arr){
        // T.C is O(N) and S.C is O(1)
        double sum =0;

        for(int i : arr){
            sum+=i;
        }

        int size = arr.length;
        double avg = sum/size;
        return avg ;
    }

    static int [] multiplyByTen(int []arr){
        // T.C is O(N) and S.C is O(N)
        int size = arr.length;
        int newArray[] = new int[size];

        for(int i = 0; i<size; i++){
            int element = arr[i];
            int newElement = element*10;
            newArray[i] = newElement;
        }

        return newArray;
    }

    static boolean linearSearch(int []arr, int target){
        // T.C is O(N) and S.C is O(1)
        for(int i=0; i<arr.length; i++)
            if(arr[i]==target) return true;

        return false;
 }

    static int maximumElement(int []arr){
        // S.C is O(1) and T.C is O(N)
        // in-built function is Math.max()
        int maxi = arr[0];
        for(int i:arr){
            /*
            if(maxi<i){
                maxi = i;
            }
            
            */
           maxi = Math.max(maxi,i);

        }
        return maxi;

    }

    static int[] sumOfPositiveAndNegativeNumbers(int []arr){
        // T.C is O(N) and S.C is O(1)
        int positiveSum =0;
        int negativeSum =0;

        for(int i:arr){
            if(i>=0) positiveSum+=i;
            else negativeSum+=i;
        }
        int []ans = {positiveSum,negativeSum};

        return ans ;
    }


    static int [] numberOfZeroesAndOnes(int []arr){
        // T.C is O(N) and S.C is O(1)

        int zeroesCount=0;
        int onesCount=0;

        for(int i:arr){
            if(i==1) onesCount++;
            else zeroesCount++;
        }

        int []ans = {zeroesCount,onesCount};
        return ans;
    }



    static int getFirstUnsortedElement(int []arr){
        // T.C is O(N) and S.C is O(1)

        // increasing order
        int value =-1;
        for(int i=0; i<(arr.length)-1;i++){
            // for increasing order 
            if(arr[i+1]<arr[i]) value=arr[i+1];
            
            else continue;
        }

        return value;
    }



    public static void main(String[] args) {

        int []arr = {9,2,3,-4,5,6};
        int [] answer = multiplyByTen(arr) ;
        System.out.println(getAverage(arr));
        System.out.println("Printing answer array ");
        for(int i:answer){
            System.out.println(i);
        }

        System.out.println(linearSearch(arr, 7));

        System.out.println(maximumElement(arr));

        System.out.println("Positive and Negative numbers are: ");
        int []ans = sumOfPositiveAndNegativeNumbers(arr);
        for(int i:ans){
            System.out.println(i);
        }

        int []zeroOne = {0,1,1,1,1,0,1,0};
        int [] zerOneCountArray = numberOfZeroesAndOnes(zeroOne);

        System.out.println("Count of Zeroes and Ones");
        for(int i: zerOneCountArray){
            System.out.println(i);
        }

        int []increasingOrder = {1,2,9,4,5,6,7};
        
        System.out.println("First Unsorted Value for Increasing Order "+getFirstUnsortedElement(increasingOrder));

 
    }
}

