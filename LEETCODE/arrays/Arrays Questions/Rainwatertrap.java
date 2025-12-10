// apna college solution 

public class Rainwatertrap {
    public static int rainwater(int [] height){
        int n = height.length;
        // to calculate lfet max first 
        int leftmax [] = new int [n];
        leftmax[0] =  height[0];
        for (int i = 1;i < n;i++){
            leftmax[i] =  Math.max(height[i], leftmax[i-1]);
        }
        // to calculate right max 
        int rightmax [] = new int [n];
        rightmax[n-1] = height[n-1];
        for(int i = n-2 ;i>=  0; i--){
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }
        int waterlevel = 0;
        int watertrapped = 0;

        for(int i = 0 ;i < n;i++){
            // calculate water level 
            waterlevel  = Math.min(leftmax[i], rightmax[i]);
            // calculatte water trapepd 
            watertrapped += waterlevel - height[i] ;
        }
        return watertrapped;

    }
    public static void main(String[] args) {
        int height [] = {4,2,0,3,2,5};

        System.out.println(rainwater(height));
    }

}
