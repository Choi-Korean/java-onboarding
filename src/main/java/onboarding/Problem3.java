package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 3; i <= number; i ++){
            answer += count369(Integer.toString(i).split(""));
        }
        return answer;
    }

    public static int count369(String[] nums){
        int result = 0;
        for(String n : nums){
            if(n.equals("3") || n.equals("6") || n.equals("9")){
                result += 1;
            }
        }
        return result;
    }
}
