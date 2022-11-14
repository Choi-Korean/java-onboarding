package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int LOWER_ASCII = 155;
        int UPPER_ASCII = 219;

        for(char c:word.toCharArray()){
            if(c == ' '){
                answer += ' ';
                continue;
            }

            if((int) c < 91){
                answer += (char) (LOWER_ASCII - (int) c);
                continue;
            }
            answer += (char) (UPPER_ASCII - (int) c);
        }
        return answer;
    }
}
