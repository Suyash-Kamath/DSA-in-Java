public class RemoveAllTheOccurrencesOfString {
    static String removeOccurrences(String s,String part){
        // 
        while(s.contains(part)){
            int index = s.indexOf(part); // left most ka index dega , lets say part is pq , so it will gice me the index of p 
            // create a new string by merging left and right remnant
            
            s = s.substring(0,index) + s.substring(index+part.length());
            
        }
        return s;
    }
    public static void main(String[] args) {
        String s = "pqxpqpqyzpq";
        String part = "pq";
        String ans = removeOccurrences(s,part);
        System.out.println(ans);
    }
}

// T.C is O(n^2 * m )
