package arrays.linearsearch;

public class linearsearch {

    public static int linearsearch(int numbers[], int key ){
        for (int i = 0;i<=numbers.length;i++){
            if(key == numbers[i]){
                return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) {

        int numbers [] = {2,45,32,12,34,45,56,12};
        int key = 12;

        int result = linearsearch(numbers, key);
        if (result == -1){
            System.out.println("key not found ");
        }else{
            System.out.println("index :" + result);
        }

        
    }
    
}
