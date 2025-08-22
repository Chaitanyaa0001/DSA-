package A2Darrays;

// Question 1 :Print the number of 7’s that are inthe 2d array.Example :Input - int[][] array = { {4,7,8},{8,8,7} };Output - 2
public class number7s {
    public static int printnumber(int array[][], int target){
        int num = 0;
        int n = array.length;
        int m = array[0].length;
        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < m; j++){
                if(array[i][j] == target){
                    num++;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int[][] array = { {4,7,8},{8,8,7} };
         int result = printnumber(array, 7);
         System.out.println(result);
    }
}
