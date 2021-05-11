package com.tddb.program;

public class Program {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";

        Program pro = new Program();
        String result = pro.solution(numbers, hand);
        System.out.println(result);
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";

        String startL = "*";
        String startR = "#";

        int left = 0;
        int right = 0;

        for(int num : numbers){
            String re = getLR(num);
            if(!re.equals("X")){
                if(re.equals("L")){
                    startL = String.valueOf(num);
                }else{
                    startR = String.valueOf(num);
                }

                answer += re;
                
            }else{
                // left = getDistance(String.valueOf(num), startL);
                // right = getDistance(String.valueOf(num), startR);

                // if(left > right){
                //     startR = String.valueOf(num);
                // }else if(left < right){
                //     startL = String.valueOf(num);
                // }else{
                //     if(hand.equals("right")){
                //         startR = String.valueOf(num);
                //     }else{
                //         startL = String.valueOf(num);
                //     }
                // }

                answer += getLeftRight(num, startL,startR, hand);
            }
        }

        return answer;

    }

    public String getLR(int num){
        if(num == 1 || num == 4 || num == 7){
            return "L";
        }else if(num == 3 || num == 6 || num == 9){
            return "R";
        }else{
            return "X";
        }
    }

    public String getLeftRight(int num, String left, String right, String hand){
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

