public class S8_LinerSearch {
    private static boolean linearsearch(int arr[], int key){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i] == key){
                return  true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,2,4,2,5,6};
        linearsearch(arr, 6);
    }
}
