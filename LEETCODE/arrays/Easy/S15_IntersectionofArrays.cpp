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

    private static int [] optimalApproch(int[] nums1, int[] nums2){
        int i = 0; 
        int j = 0;
        int n = nums1.length, m = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < n && i < m) {
            if(nums1[i] == nums2[j]){
                if(list.size() == 0 || list.get(list.size() - 1) != nums1[i]){
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return list.stream().sorted().mapToInt( k -> k).toArray();
    }
    public static void main(String[] args) {
        intersectionofarrays(null, null);
        optimalApproch(null, null);

    }
}
