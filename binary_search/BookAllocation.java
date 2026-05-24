public class BookAllocation {

    static boolean isValid(int arr[],int k, int maxPages){
        //check whether mid or maxPage is a valid solution or not 
        int studentCount = 1;
        int pages =0;

        for(int i=0;i<arr.length;i++){
            if(pages+arr[i]<=maxPages){
                // current book can be assigned 
                // as it is not out of limit
                // then assign

                pages = pages + arr[i];

            }else{
                // current student ko current book cannot be assigned wala case

                studentCount++;
                if(studentCount>k || arr[i]>maxPages){
                    return false;
                }
                else{
                    // can assign to new student 
                    pages =0;
                    pages+=arr[i];
                }
            }
        }
        return true ;
    }
    static int findPages(int []arr,int k){

        // to find valid ans , books count >= students present 

        if(arr.length<k){
            return -1;
        }
        int n = arr.length;
        int s = 1;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        int e = sum;

        int ans =-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(isValid(arr,k,mid)){
                ans = mid ;
                e = mid-1;
            }else{
                s=mid+1;
            }

        }
        return ans ;
    }
    public static void main(String[] args) {
        int arr[] = {12,34,67,90};
        int k = 2;
        int ans = findPages(arr,k);
        System.out.println(ans);
    }
}
