package com.tddb.program;

public class Program {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        String startL = "*";
        String startR = "#";

        for(int num : numbers){
            answer += getLeftRight(num, 
                                Integer.parseInt(startL), 
                                Integer.parseInt(startR),
                                hand);
        }

        return answer;

    }

    public String getLeftRight(int num, int left, int right, String hand){
        if(num == 1 || num == 4 || num == 7){
            return "L";
        }else if(num == 3 || num == 6 || num == 9){
            return "R";
        }else{
            int numL = getDistance(String.valueOf(num), String.valueOf(left));
            int numR = getDistance(String.valueOf(num), String.valueOf(right));

            if(numL > numR){
                return "R";
            }else if(numL > numR){
                return "L";
            }else{
                return hand.substring(0,1).toUpperCase();
            }
        }
    }

    public int getDistance(String num1, String num2) {

        int[] pos1 = getPos(num1);
        int[] pos2 = getPos(num2);

        int result = Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);

        return result;
    }

    public int[] getPos(String num){
        String[][] phone = {
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"},
            {"*","8","#"},
        };

        int x = 0;
        int y = 0;

        for(int i = 0; i < phone.length; i++){
            for(int j = 0 ; j < phone[i].length; j++){
                if(num.equals(phone[i][j])){
                    x = i+1;
                    y = j+1;
                }
            }
        }

        int[] pos = {x,y};

        return pos;
    }

    
}

