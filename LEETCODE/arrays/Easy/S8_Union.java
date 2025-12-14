import LEETCODE.arrays.ArrayInput;

public class S8_Union {
    public static int[] findUnionfromarrays(int[] num1, int[] num2){
        int[] temp = new int[10000];
        int x = 0;

        int ptr = 0;
        int ptr2 =0 ;
        while (num1[ptr] > 0 && num2[ptr2] >= 0) {
            if(num1[ptr] <= num2[ptr2]){
                temp[x++]  = num1[ptr++];
            }else{
                temp[x++]  = num2[ptr2++];
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] num1 = ArrayInput.takeArrayInput();
        int[] num2 = ArrayInput.takeArrayInput();
        findUnionfromarrays(num1, num2);

    }
}
