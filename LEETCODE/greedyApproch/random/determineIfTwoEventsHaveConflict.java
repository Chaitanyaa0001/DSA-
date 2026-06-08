package LEETCODE.greedyApproch.random;

public class determineIfTwoEventsHaveConflict {
    private static boolean evintents(String event1[], String event2[]){
    String s1 = event1[0];
    String e1 = event1[1];

    String s2 = event2[0];
    String e2 = event2[1];

        return s1.compareTo(e2) <= 0 && s2.compareTo(e1) <= 0;
    }
    public static void main(String[] args) {
        String[] event1 = {"11:00","12:00"};
        String[] event2 = {"14:00","15:00"};
        evintents(event1, event2);
    }
}
