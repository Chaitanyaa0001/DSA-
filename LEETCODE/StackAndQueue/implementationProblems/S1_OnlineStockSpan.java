package LEETCODE.StackAndQueue.implementationProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S1_OnlineStockSpan {
//     class StockSpanner {
//     List<Integer> list;

//     public StockSpanner() {
//         list = new ArrayList<>();
//     }

//     public  int next(int price) {
//         list.add(price);
//         int count = 1;
//         for(int i = list.size() - 2; i >= 0; i--){
//             if(list.get(i) <= price){
//                 count++;
//             }else{
//                 break;
//             }
//         }
//         return count;
//     }
// }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// now optimal 


  class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public  int next(int price) {
        int span = 0;
        int count = stack.peek()[1];

        if(stack.isEmpty()){
            stack.push(new int[]{price,0});
        }else{
            while ( !stack.isEmpty() && stack.peek()[0] <= price) {
                stack.pop();
            }
            span =  (count+ 1) -  stack.peek()[1];
            stack.push(new int[]{price, count + 1});
        }
        return span;
    }
}


    
    public static void main(String[] args) {
        
    }
}
