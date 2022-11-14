package onboarding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = cryptogram;
        String result = "";

        while(true){
            result = arrangeString(answer);
            if(answer.length() == result.length()){
                answer = result;
                break;
            }

            answer = result;
        }

        return answer;
    }

    public static String arrangeString(String before){
        String result = "";
        char noUse = 'X';
        char now;

        for(int i = 0; i < before.length() - 1; i ++){
            now = before.charAt(i);
            if(now != noUse && now != before.charAt(i + 1)){
                result += now;
                if(i == before.length() - 2){
                    result += before.charAt(i + 1);
                }
                continue;
            }

            noUse = now;

            if(i == before.length() - 2 && now != before.charAt(i + 1)){
                result += before.charAt(i + 1);
            }

        }
        return result;
    }

}
