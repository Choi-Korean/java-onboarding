package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList();
        HashMap<String, Integer> uniqueNames = new HashMap<>();

        for(List<String> form:forms){
            splitName(form.get(1), uniqueNames);
        }

        for(List<String> form:forms){
            checkRedup(form, uniqueNames, answer);
        }
        answer = answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);

        return answer;
    }

    public static void splitName(String name, HashMap<String, Integer> uniqueNames){
        String now;
        for(int i = 0; i < name.length(); i ++){
            now = Character.toString(name.charAt(i));
            for(int j = i + 1; j < name.length(); j ++){
                now += name.charAt(j);
                uniqueNames.put(now, uniqueNames.getOrDefault(now, 0) + 1);
            }
        }
    }

    public static void checkRedup(List<String> form, HashMap<String, Integer> uniqueNames, List<String> answer){
        String now;
        String name = form.get(1);
        for(int i = 0; i < name.length(); i ++){
            now = Character.toString(name.charAt(i));
            for(int j = i + 1; j < name.length(); j ++){
                now += name.charAt(j);
                if(uniqueNames.get(now) > 1){
                    answer.add(form.get(0));
                }
            }
        }
    }
}
