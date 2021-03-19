package com.vignesh;

import java.util.*;

public class Meeting {
    public static void main(String[] args){
        System.out.println("Hello");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<100;i++){
            minHeap.add(i);
            maxHeap.add(i);
        }
        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());
        minHeap.offer(1);
        int[][] meeting ={{1,2},{4,5},{8,10}};
        System.out.println(minMeetingRooms(meeting));
        int[][] queries ={{2,3},{3,4}};
        System.out.println(checkIfMeetingPossible(meeting,queries,1));
    }
    /*
    Input: calendar = [[1, 2], [4, 5], [8, 10]], rooms = 1, queries = [[2, 3], [3, 4]]
Output: [true, true]

Input: calendar = [[1, 2], [4, 5], [8, 10]], rooms = 1, queries = [[4, 5], [5, 6]]
Output: [false, true]

Input:
calendar = [[1, 3], [4, 6], [6, 8], [9, 11], [6, 9], [1, 3], [4, 10]]
rooms = 3
queries = [[1, 9], [2, 6], [7, 9], [3, 5], [3, 9], [2, 4], [7, 10], [5, 9], [3, 10], [9, 10]]
Output: [false, true, false, true, false, true, false, false, false, true]

    */
    private  static boolean[] checkIfMeetingPossible(int[][] meetingTimings, int[][] queries,int rooms){
        boolean[] bool = new boolean[queries.length];
        int q = 0;
        int[][] newarray = new int[meetingTimings.length+1][2];

        for(int[] query: queries){
            newarray[meetingTimings.length+1][0] = query[0];
            newarray[meetingTimings.length+1][1] = query[1];


            if(rooms <= minMeetingRooms(newarray)){
                bool[q] = true;
            }
            else{
                bool[q] = false;
            }
            q++;
            newarray[meetingTimings.length+1][0] = 0;
            newarray[meetingTimings.length+1][1] = 0;
        }
        return bool;
    }
    private static int minMeetingRooms(int[][] meetingTimings){
        int count =0;
        //Arrays.sort(meetingTimings, new customComparator());
        Arrays.sort(meetingTimings , (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int[] timings : meetingTimings){
            if(minHeap.isEmpty()){
                count++;
                minHeap.offer(timings[1]);
            }else{
                if(timings[0] >= minHeap.peek()){
                    minHeap.poll();
                }else{
                    count++;
                }
                minHeap.offer(timings[1]);
            }

        }
        return count;
    }

}
