package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<Object, ArrayList<String>> friendsList = new HashMap<>();
        HashMap<String, Integer> recommended = new HashMap<>();
        String f1;
        String f2;
        ArrayList<String> fList1;
        ArrayList<String> fList2;

        for(List<String> f:friends){
            f1 = f.get(0);
            f2 = f.get(1);
            fList1 = friendsList.getOrDefault(f1, new ArrayList<String>());
            fList1.add(f2);
            friendsList.put(f1, fList1);

            fList2 = friendsList.getOrDefault(f2, new ArrayList<String>());
            fList2.add(f1);
            friendsList.put(f2, fList2);
        }
        
        // 친구공유 체크
        for(String f:friendsList.get(user)){
            for(String ff: friendsList.get(f)){
                if(ff.equals(user)){
                    continue;
                }
                recommended.put(ff, recommended.getOrDefault(ff, 0) + 10);
            }
        }
        
        // 방문유무 체크
        for(String f:visitors){
            recommended.put(f, recommended.getOrDefault(f, 0) + 1);
        }

        // 정렬
        // 1. HashMap to Friends 객체
        List<Friends> recommendedSorted = new ArrayList<>();
        Friends temp;

        for(String k:recommended.keySet()){
            temp = new Friends(k, recommended.get(k));
            recommendedSorted.add(temp);
        }

        // 2. 점수순, 이름순 정렬
        recommendedSorted.sort(Comparator.comparing(Friends::getPoints).reversed().thenComparing(Friends::getName));

        // 정렬된 값, 현재 user의 친구가 아니고 user도 아닌 값들 5개까지 차례대로 넣기.
        for(Friends f:recommendedSorted){
            if(f.getName().equals(user) || friendsList.get(user).contains(f.getName())){
                continue;
            }
            answer.add(f.getName());
            if(answer.size() == 5){
                break;
            }
        }

        return answer;
    }

    public static class Friends{

        String name;
        int points;

        public Friends(String name, int points){
            this.name = name;
            this.points = points;
        }

        public String getName(){
            return this.name;
        }

        public int getPoints(){
            return this.points;
        }
    }

}
