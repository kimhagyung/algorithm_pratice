package algorithm_pratice.pro_0420;

import java.util.*;

public class Stack_Queue_주식가격 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] prices = { 1, 2, 3, 2, 3 };
		sol.solution(prices); 
	}
} 
class Solution {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        System.out.println("=== prices 순회 시작 (for문) ===");
        for (int i = 0; i < prices.length; i++) {
            System.out.println("\n[i = " + i + ", prices[i] = " + prices[i] + "]");

            // 현재 가격이 스택 최상단 인덱스의 가격보다 낮은지 확인
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop(); // 가격 하락이 결정된 과거의 시점
                answer[index] = i - index; // 하락까지 걸린 시간 계산
                
                System.out.println("  >> 가격 하락 발견! (prices[stack.peek()] > prices[i])");
                System.out.println("     pop 실행 -> index: " + index);
                System.out.println("     계산 발생 -> answer[" + index + "] = " + i + " - " + index + " = " + answer[index]);
            }
            
            stack.push(i);
            System.out.println("  >> stack.push(" + i + ") 실행 | 현재 stack: " + stack);
        }

        System.out.println("\n=== 남은 데이터 처리 (while문) ===");
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
            
            System.out.println("  >> 끝까지 하락 없음 -> index: " + index);
            System.out.println("     계산 발생 -> answer[" + index + "] = (" + (prices.length - 1) + ") - " + index + " = " + answer[index]);
            System.out.println("     현재 stack: " + stack);
        }

        System.out.println("\n최종 결과 answer: " + Arrays.toString(answer));
        return answer;
    }
}