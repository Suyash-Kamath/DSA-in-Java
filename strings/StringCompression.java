
// homework for you is to  try solve with string builder method 
public class StringCompression {
    
    static int compress(char[] chars){
        
        int readIndex = 0;
        int writeIndex=0;
        
        while(readIndex<chars.length){
            char currentChar = chars[readIndex];
            int count =0;
            
            // count duplicate character
            while(readIndex<chars.length && currentChar==chars[readIndex]){
                readIndex++;
                count++;
            }
            
            // mere paas current character and its count , dono available hai 
            chars[writeIndex]=currentChar;
            writeIndex++;
            // now insert the count 
            
            if(count>1){
                String countStr = String.valueOf(count);
                for(char digit: countStr.toCharArray()){
                    chars[writeIndex] = digit ;
                    writeIndex++;
                }
            }
            
        }
        
        // return the length of compressed string;
        
        return writeIndex;
        
        
    }
    public static void main(String[] args) {
       char [] chars={'a','a','b','b','c','c','c'};
       int ans = compress(chars);
       System.out.println(ans);
    }
}

// O(N) is Time complexity and O(1) space complexity 
