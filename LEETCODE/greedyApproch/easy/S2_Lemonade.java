package LEETCODE.greedyApproch.easy;

public class S2_Lemonade {

    private static boolean lemonade(int a[]){
        int five = 0, ten = 0;
        int n= a.length;
        for(int i = 0; i < n; i++){
            if(a[i] == 5){
                five++;
            }else if(a[i] == 10){
                if(five > 0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if( five >= 3){
                    five -=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int [] a = {5,5,10,20};
        lemonade(a);
    }
}