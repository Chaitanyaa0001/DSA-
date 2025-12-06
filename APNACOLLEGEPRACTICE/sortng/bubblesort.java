package sortng;

import LEETCODE.patterns.BasicPatterns.starPattern;

public class bubblesort {
    public static void bubble(int [] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    
    public static void sortedarr(int  [] arr){
        for(int i =0; i< arr.length; i++ ){
            System.out.print( "" + arr[i]  );
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr [] = {8,5,4,3,5,6,7};
        bubble(arr);
        sortedarr(arr);

    }
    
}
