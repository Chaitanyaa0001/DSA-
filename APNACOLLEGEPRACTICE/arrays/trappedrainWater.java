package arrays;

public class trappedrainWater {
    public static void areaWater(int[] heights ){
        int width = 1;
        int[] leftmax = new int[heights.length];
        int[] rightmax = new int[heights.length];

        for(int i = 1; i < heights.length; i++){
            leftmax[i] = Math.max(heights[i], leftmax[i-1]);
        }
        for(int i = heights.length-2 ; i >= 0; i--){
            rightmax[i] = Math.max(heights[i], rightmax[i+1]);
        }
       
        int waterTrapped = 0;
        for(int i = 0; i <= heights.length; i++){
            int waterlevel= Math.min(rightmax[i],leftmax[i]);
            waterTrapped =  waterTrapped + (heights[i] - waterlevel)  *  width;
        }
        System.out.println(waterTrapped); 
    }
//     class Solution {
//     public int trap(int[] height) {
//         int lmax = 0, rmax = 0;

//         int left = 0, right = height.length-1;
//         int trapped = 0;
//         while(left <= right){
//             if(height[left] <= height[right]){
//                 if(height[left] > lmax){
//                     lmax = height[left];
//                 }else{
//                     trapped += lmax - height[left];
//                 }
//                 left++;
//             }else{
//                 if(height[right] > rmax){
//                     rmax = height[right];
//                 }else{
//                     trapped += rmax - height[right];
//                 }
//                 right--;
//             }
//         }
//         return trapped;
//     }
// }

    public static void main(String[] args) {
        int[] heights = {4,2,0,6,3,2,5};

        areaWater(heights);
    }
}
