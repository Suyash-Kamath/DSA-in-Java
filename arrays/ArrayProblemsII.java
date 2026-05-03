import java.util.HashMap;

public class ArrayProblemsII {

    static void reverseArray(int []arr){
        // T.C is O(N/2 + N) and S.C is O(1)
        int i =0;
        int j = arr.length-1;
        int temp =0;
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp ;
            i++;
            j--;
        }
     }

     static void shiftByOnePosition(int []arr){
        // T.C is O(N) and S.C is O(1)
        int i = arr.length-1;
        while (i>0) {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
            i--;
        }
     }

     static void extremeElementsInAlternateManner(int []arr){
        // T.C is O(N/2) and S.C is O(1)
        int i =0;
       
        int j = arr.length-1;
       // correct code by makes difficult to read because it mixes loop condition + internal break → slightly harder to read/debug
       /*
       while (i<j) {
            System.out.println(arr[i] + " " + arr[j]);
            i++;
            j--;
            if(i==j){
                System.out.println(arr[i]);
                break;
            }

        }
       */
        while (i<=j) {
            if(i==j){
                System.out.println(arr[i]);
            }
            else{
                System.out.println(arr[i]);
                System.out.println(arr[j]);
            }
            i++;
            j--;
        }
     }

     static int modeOfArray(int []arr){

        // T.C is O(N+N) and S.C is O(N)
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:arr){
            freq.put(num,freq.getOrDefault(num, 0)+1);
        }
        // for(int i:freq.keySet()){
        //     // i-> represent key 
        //     System.out.println(i + "-> "+ freq.get(i));
        // }
        int maxFreq = -1;
        int maxFreqKey =-1;

        /*
        

maxFreq = currentKeyFreq;

But here’s the key point: a variable being assigned is not the same as it being used.

What your IDE/compiler means by “not used”

A variable is considered used only if its value actually affects logic later.

In your original code:

if (currentKeyFreq > maxFreqKey) {
    maxFreq = currentKeyFreq;
    maxFreqKey = currentKey;
}
maxFreq is assigned
but it is never read/checked anywhere
your condition depends on maxFreqKey, not maxFreq

👉 So maxFreq doesn’t influence any decision → effectively useless → warning.

Think of it like this

You’re maintaining two variables:

maxFreq → highest frequency
maxFreqKey → corresponding element

But your condition should depend on maxFreq, not maxFreqKey.

Correct logic flow
if (currentKeyFreq > maxFreq) {
    maxFreq = currentKeyFreq;   // used to track best frequency
    maxFreqKey = currentKey;    // used to track element
}

Now:

maxFreq is read in the condition
so it actually controls the algorithm
Simple analogy

It’s like writing:

int x = 10;
x = 20;

If you never use x in a condition, print, or return — the compiler says:
👉 “Why did you even create this variable?”

Bottom line

✔ Assigned ≠ Used
✔ Used = participates in logic (conditions, return, output, etc.)
        */

        for(int key: freq.keySet()){
            int currentKey = key;
            int currentKeyFreq = freq.get(key);

            if(currentKeyFreq>maxFreq){
                maxFreq = currentKeyFreq;
                maxFreqKey = currentKey;
            }
        }

        return maxFreqKey;

     }




     static int[] highestAndLowestFrequency(int[]arr){
        // T.C is O(N+N+N) and S.C is O(N) , 
        HashMap<Integer,Integer>freq =new HashMap<>();
        for(int k:arr){
            // If k exists in the map → return its value
            // If k does NOT exist → return 0
            freq.put(k,freq.getOrDefault(k,0)+1);

        }

        int highestFreq = Integer.MIN_VALUE;
        int highestNum =-1;

        for(int k:freq.keySet()){
            int currentKey = k;
            int currentKeyFreq = freq.get(k);

            if(currentKeyFreq > highestFreq){
                highestFreq = currentKeyFreq;
                highestNum = currentKey ;
            }

        }

        int lowestFrequency = Integer.MAX_VALUE;
        int lowestNum = -1;

        for(int k:freq.keySet()){
             int currentKey = k;
            int currentKeyFreq = freq.get(k);

            if(currentKeyFreq < lowestFrequency){
                lowestFrequency = currentKeyFreq;
                lowestNum = currentKey;
            }
        }

        int []ans = {highestNum,lowestNum};
        return ans;

     }

    public static void main(String[] args) {
        int arr1[] = {2,4,6,8,9};
        reverseArray(arr1);
        System.out.println("Reversed array: ");
        for(int k: arr1){
            System.out.println(k);
        }

        int arr2[] = {10,20,30,40,50,60,70};
        shiftByOnePosition(arr2);
        System.out.println("Shifted Array Elements why one position");
        for(int k: arr2){
            System.out.println(k);
        }

        int []arr3 = {5,3,7,6,9};
        extremeElementsInAlternateManner(arr3);

        int []arr4 ={1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,6,6,6,6,6,6};
        int answer =modeOfArray(arr4);
        System.out.println("Mode of array is "+answer);

        int []answer2 = highestAndLowestFrequency(arr4);
        System.out.println("Highest freq number "+answer2[0]+" and Lowest Frequence Number "+ answer2[1]);
        

    }
}
