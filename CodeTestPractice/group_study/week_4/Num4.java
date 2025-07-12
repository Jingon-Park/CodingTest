package group_study.week_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Num4 {
    static class Solution {
        public String[] solution(String[][] plans) {
            List<String> answerList = new ArrayList<>();

            LinkedList<Plan> planList = new LinkedList<>();
            Stack<Plan> stopPlans = new Stack<>();

            for (String[] plan : plans) {
                String name = plan[0];
                String[] startTimeStr = plan[1].split(":");
                int playTime = Integer.valueOf(plan[2]);
                int startTime =
                    (Integer.valueOf(startTimeStr[0]) * 60) + Integer.valueOf(startTimeStr[1]);

                Plan addPlan = new Plan(name, startTime, playTime);
                planList.add(addPlan);
            }

            Collections.sort(planList, new Comparator<Plan>() {
                @Override
                public int compare(Plan o1, Plan o2) {
                    return o1.startTime - o2.startTime;
                }
            });

            int currentTime = 0;

            for (Plan plan : planList) {
                while (!stopPlans.isEmpty()) {
                    Plan target = stopPlans.pop();
                    if (currentTime + target.remainTime <= plan.startTime) {
                        answerList.add(target.name);
                        currentTime += target.remainTime;
                    }else {
                        target.remainTime -= (plan.startTime - currentTime);
                        stopPlans.push(target);
                        break;
                    }
                }
                currentTime = plan.startTime;
                stopPlans.push(plan);
            }

            while (!stopPlans.isEmpty()) {
                answerList.add(stopPlans.pop().name);
            }

            return answerList.toArray(new String[]{});
        }

        class Plan {
            public String name;
            public int startTime;
            public int remainTime;

            public Plan(String name, int startTime, int remainTime) {
                this.name = name;
                this.startTime = startTime;
                this.remainTime = remainTime;
            }

            @Override
            public String toString() {
                return "Plan{" +
                    "name='" + name + '\'' +
                    ", startTime=" + startTime +
                    ", remainTime=" + remainTime +
                    '}';
            }
        }
    }
    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"},
            {"math", "12:30", "40"}};
        Solution solution = new Solution();

        String[] result = solution.solution(plans);

        for (String s : result) {
            System.out.print(s + " ");
        }
    }

}
