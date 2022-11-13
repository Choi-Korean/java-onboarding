package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.nCopies(9, 0));
        int count;
        int n = 1;
        int curr = 50000;

        for(int i = 0; i < 9; i ++){
            count = money / curr;
            answer.set(i, count);
            money -= count * curr;

            if(money == 0){
                break;
            }

            n += 1;
            if(n == 9){
                curr = 1;
                continue;
            }
            if(n % 2 == 0){
                curr /= 5;
                continue;
            }

            curr /= 2;
            continue;
        }

        return answer;
    }
}
