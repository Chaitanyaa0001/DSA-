package LEETCODE.SlidingWindow;

public class S5_FruitsinBasket2 {
    private  static  int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // {4,2,5} {3,5,4}
        int n = fruits.length;
        
        int[] marked = new int[n];
        int unplaced = 0;
        for(int i = 0; i < n; i++){
            boolean placed = false;
            for(int j = 0; j < baskets.length; j++){
                if(fruits[i] <= baskets[j] && marked[j] == 0){
                    marked[j] = 1;
                    placed = true;
                    break;
                }
            }
            if(!placed){
                unplaced++;
            }
        }
            return unplaced;
    }
    public static void main(String[] args) {
        int a[] = {4,2,5};
        int b[] = {3,5,4};
        numOfUnplacedFruits(a, b);
    }
}
