
public class PermutationInString {
    
    static boolean compareFreq(int []count1,int []count2){
        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i]){
                return false;
            }
        }
        return true;
    }
    static boolean checkInclusion(String s1,String s2){
      // algo wise 
      // basic check -> whether s1 ke characters present in s2 or not 
      // s1 ka table ready 
      // s2 ki first window ko process
      // s2 ki remaining window ko process karlete hai 
      
      if(s1.length()>s2.length()){
          return false;
         
      }
      int count1[] = new int[26];
      for(int i=0;i<s1.length();i++){
          char ch  = s1.charAt(i);
          int index = ch-'a';
          count1[index]++;
          
      }
      
      int i =0;
      int windowLength= s1.length();
      int count2[] = new int[26];
      // first window ka freq table 
      for(i=0;i<windowLength;i++){
          char ch = s2.charAt(i);
          int index = ch-'a';
          count2[index]++;
      }
      
      if(compareFreq(count1,count2)==true){
          return true;
      }else{
          // both the freq are not matching 
          //process remainging windows
          
          while(i<s2.length()){
              // new window par move kar rahe ho , new character ko freq table me add
              // ord chaarcter ki entry ko table me se remove kardena mere bhai 
              // apke paas updated tabel for new window
              // comapre with s1 ke reference table se 
              // i mere new character ke upar already baitha hai 
              
              char newChar = s2.charAt(i);
              int newCharIndex = newChar-'a';
              count2[newCharIndex]++;
              int oldCharIndex = i-windowLength;
              char oldChar = s2.charAt(oldCharIndex);
              int freqTableIndexofOldChar = oldChar-'a';
              count2[freqTableIndexofOldChar]--;
              
              if(compareFreq(count1,count2)==true){
                    
                  return true;
              }
                //   yahape me hamesha galti kar deta hu 
              i++;
              
          }
          return false;
      }
      
    }
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean ans = checkInclusion(s1,s2);
        System.out.println(ans);
    }
}
