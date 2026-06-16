
public class RemoveAllAdjacentDuplicates {
    
    static String removeDuplicates(String s){
        
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            // compare ans ke rightmost character ko current character se
            
            if(ans.length()>0 && ans.charAt(ans.length()-1)==ch){
                ans.deleteCharAt(ans.length()-1);
            }else{
                ans.append(ch);
            }
        }
        
        return ans.toString();
        
    }
    public static void main(String[] args) {
        String s= "abbaca";
        String ans = removeDuplicates(s);
        System.out.println(ans);
    }
}

// O(N) is Time complexity and O(N) space complexity 
