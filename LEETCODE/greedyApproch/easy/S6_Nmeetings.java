package LEETCODE.greedyApproch.easy;

import java.util.Arrays;

public class S6_Nmeetings {

    static class meeting{
        int start;
        int end; 
        int position;
        meeting(int start, int end, int position){
            this.start = start;
            this.end = end; 
            this.position = position;
        }
    }

    private static int  nmeetings(int s[], int e[]){
        int n = s.length;
        int m = e.length;
        int maxpeeting = 0;
        // isme maine apnmi sari meeting store kari hai 
        // ( start, end , index )
        meeting[] meet = new meeting[n];

        for(int i =0; i < n; i++){
            meet[i] = new meeting(s[i], e[i], i);
        }

        Arrays.sort(meet, (a,b) -> a.end - b.end);

        int count = 1; 
        int freetinme = meet[0].end;

        for(int i = 1; i < meet.length; i++){
            int starttime = meet[i].start;
            if(starttime > freetinme){
                count++;
                freetinme = meet[i].end;
            }
        }

        return count;

    }
    public static void main(String[] args) {
        int Start[] = {0,3,1,5,5,8};
        int End[] =   {5,4,2,9,7,6};

        nmeetings(Start, End);
    }
}
