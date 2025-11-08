package Java.Easy;

import java.util.Stack;

public class _682_BaseballGame {
    public static void main(String[] args) {
        System.out.println("#682 - Baseball Game - Easy");

        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int totalPoints = calPoints(ops);
 
        System.out.println("Total Points: " + totalPoints);

        return;
    }

    private static int calPoints(String[] operations) {
        Stack<Integer> pointStack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("D")) {
                pointStack.push(pointStack.peek() * 2);
            }
            else if (operations[i].equals("C")) {
                pointStack.pop();
            }
            else if (operations[i].equals("+")) {
                int top = pointStack.pop();
                int sum = top + pointStack.peek();
                pointStack.push(top);
                pointStack.push(sum);
            }
            else {
                pointStack.push(Integer.parseInt(operations[i]));
            }
        }

        int count = 0;
        while (!pointStack.isEmpty()) {
            count = count + pointStack.pop();
        }

        return count;
    }
}
