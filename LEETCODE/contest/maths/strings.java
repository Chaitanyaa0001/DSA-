public class strings {
    
    public static  boolean isAdjacentDiffAtMostTwo(String s) {
        int n  = s.length();
    
        for(int i = 1; i < n-1; i++){
            int curr  = s.charAt(i) - '0';
            int prev = s.charAt(i-1) - '0';
            int sum = Math.abs(prev - curr) ;
            if(sum  > 2){
                return false;
            }   
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}