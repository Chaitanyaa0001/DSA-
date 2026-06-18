public class S3_lcheckIfarrayisSorted {
    private static boolean fun(int a[]){
        int n = a.length;
        int count = 0;
        for(int i = 1; i < n;i++){
            if( a[i] > a[i+1]){
                count++;
            }

            if( count > 1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr [] = {1,2,1,4,5};
        fun(arr);
    }
}
