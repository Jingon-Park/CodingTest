package group_study.week_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Num4 {
    static class Solution {
        public String[] solution(String[][] plans) {
            List<String> answerList = new ArrayList<>();

            List<Plan> planList = new ArrayList<>();
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

            for (int i = 0; i < plans.length; i++) {
                Plan plan = planList.get(i);
                if (i + 1 < plans.length) {
                    Plan nextPlan = planList.get(i + 1);
                    if (plan.startTime + plan.remainTime <= nextPlan.startTime) {
                        answerList.add(plan.name);
                        int currentTime = plan.startTime + plan.remainTime;
                        if (!stopPlans.isEmpty()) {
                            while (currentTime < nextPlan.startTime && !stopPlans.isEmpty()) {
                                Plan stopedPlan = stopPlans.pop();
                                if (currentTime + stopedPlan.remainTime <= nextPlan.startTime) {
                                    answerList.add(stopedPlan.name);
                                    currentTime += stopedPlan.remainTime;
                                } else {
                                    stopedPlan.remainTime =
                                        stopedPlan.remainTime - (nextPlan.startTime - currentTime);
                                    stopPlans.push(stopedPlan);
                                }
                            }
                        }
                    } else {
                        plan.remainTime = plan.remainTime - (nextPlan.startTime - plan.startTime);
                        stopPlans.push(plan);
                    }
                } else {
                    answerList.add(plan.name);
                }
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
