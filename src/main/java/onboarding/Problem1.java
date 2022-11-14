package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiPoint = 0;
        int crongPoint = 0;

        try{
            pobiPoint = calPoints(pobi);
            crongPoint = calPoints(crong);
            if(pobiPoint == -2 || crongPoint == -2){
                throw new Exception();
            }
        }catch(Exception e) {
            return -1;
        }

        if(pobiPoint > crongPoint){
            return 1;
        }

        if(pobiPoint < crongPoint){
            return 2;
        }

        if(pobiPoint == crongPoint){
            return 0;
        }
        return -1;
    }

    public static int calPoints(List<Integer> page) throws Exception{

        if(page.get(1) - page.get(0) != 1 || page.get(1) % 2 != 0){
            return -2;
        }
        int page1 =  Arrays.stream(Integer.toString(page.get(0)).split("")).mapToInt(Integer::valueOf).sum();
        int page2 =  Arrays.stream(Integer.toString(page.get(0)).split("")).mapToInt(Integer::valueOf).reduce(1, (a, b) -> a*b);
        return Math.max(page1, page2);
    }
}