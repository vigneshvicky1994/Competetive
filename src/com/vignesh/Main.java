package com.vignesh;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");
        String str  = "ANCABCDEFGHAIJKLMNOPQZTRSTUVWXYZ";
        int[] arr = findAllIndexofA(str);
        int min_result = Integer.MAX_VALUE;
        //System.out.println(solve("AIJKLMNOPQZTRSTUVWXYZ"));
        for(int j=0;j<arr.length;j++){
            String s = str.substring(arr[j],str.length());
            //System.out.println(s);
            int val = solve(s);
            if(val != 0) {
                min_result = Math.min(min_result, solve(s));
            }
        }
        System.out.println(min_result);
        //System.out.println(solve(str));
    }
    static int solve(String str){
        System.out.println(str);
        if(str.length() < 26){
            System.out.println(str +  "returned zero ");
            return 0;
        }
        int count = 1;
        int valid_count = 1;
        for(int i=1;i<str.length();i++){
            count++;
            char c = str.charAt(i);
            if(c == 'A' + valid_count ){
                valid_count++;
            }
            if(c == 'Z' && valid_count == 26){
                System.out.println(str +  "returned  " + count);
                return count;
            }
        }
        System.out.println(str +  "returned zero ");
        return 0;
    }
    static int[] findAllIndexofA(String str){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'A'){
                //System.out.println(i);
                list.add(i);
            }
        }
        int[] r_arr = new int[list.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < list.size(); i++)
            r_arr[i] = list.get(i);
        return r_arr;
    }
}
