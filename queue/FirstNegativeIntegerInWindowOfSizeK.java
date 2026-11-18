import java.util.*;


/*
  Window ke andhar sirf relevant element hi store karna 
    Observation is 
    Window of K size for track
    window ke andhar sirf relevant element hi store karna hai
    Relevant element means value yaa fir index store , if you store index , then +ve store karne ki need hai , agar values se jaaoge toh store karna padge shayad
    value store kiya toh positive bhi include karne padega , kyuki ek value nikalna hai and ek value add karna padega
     har window ke me first element is the relevant answer


     Approach
     1. Process first window , means create first window using the doubly ended queue by seeing first k element
     2. process remining window -> remove and add  irrelevatn and relevant  , nikaalne se pehele first check if it is under the window or not , then only remove it , jo deque me hai uski baat kar raha hu 





 */

public class FirstNegativeIntegerInWindowOfSizeK {
    public static List<Integer> firstNegativeInteger(int arr[],int k){
        // will store indexes inside the deque
        Deque<Integer> dq= new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        // step 1: process first window of size k 

        for (int i=0;i<k;i++){
            int element = arr[i];
            if (element<0){
                // relevant element hai , store karna hai index 
                dq.offerLast(i);
            }
        }
        // first k elements ko process karna chahta hu
        // first window ke liye answer store karna hai
        if(dq.size()==0){
            ans.add(0);
        }else{
            
            ans.add(arr[dq.peekFirst()]);
        }

        // step2 : process remainging windows
        for(int i=k;i<arr.length;i++){
            // remove the irrelevant elements
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            // add or include new elements
            if(arr[i]<0){
                dq.offerLast(i);
            }

            // find or store answer for current window
            if(dq.size()==0){
                ans.add(0);
            }else{
                ans.add(arr[dq.peekFirst()]);
            }
        }
        // remove the irrelevant elements
        // add or include new elements
        // find or store answer for current window



        return ans;

    }

    public static void main(String []args){
        
        int arr[] = {12,-1,-7,8,-15,30,16,28};
        int k=3;
        List<Integer> ans = firstNegativeInteger(arr,k);
        System.out.println(ans);

    }
}
