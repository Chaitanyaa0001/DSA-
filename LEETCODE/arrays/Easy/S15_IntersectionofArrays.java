import java.util.ArrayList;

public class S15_IntersectionofArrays {
    private static int[] intersectionofarrays(int[] nums1, int[] nums2){
        boolean[] visited  = new boolean[nums2.length];
        int n = nums1.length, m = nums2.length;
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i  = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (nums1[i] == nums2[j] && visited[j] == false) {
                    list.add(nums1[i]);
                    visited[j] = true;
                    break;
                }
                if(nums2[j] > nums1[i]){
                    break;
                }
            }
        }
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {

    }
}
