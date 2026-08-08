package daily.strings;

public class L3302_findtheLexographicallyValidsmallestSequence {
    
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(); // 5
        int m = word2.length(); // 3

        int i = n - 1;  //4
        int j = m - 1; // 3

        int  suffix[] = new int[n+1]; 
        int count = 0;
        while(i >= 0  ){
            if(  j >= 0 &&   word1.charAt(i) == word2.charAt(j) ){
                count++;
                j--;
            }
            suffix[i] = count;
            i--;
        }

        i = 0; 
        j = 0;
        boolean power = true;
        int seq[] = new int[m];

        int x = 0;
        while(i < n && j < m){
            if(word1.charAt(i) == word2.charAt(j) ){
                seq[x++] = i;
                j++;
                // agra mera dono barabar nhi hai 
            }else if(power &&  suffix[i+1] >=  (m-j-1)){
                seq[x++] = i;
                power = false;
                j++;
            }
            i++;
        }
        return j == m ? seq : new int[]{};
    }

    public static void main(String[] args) {
        
    }
}
