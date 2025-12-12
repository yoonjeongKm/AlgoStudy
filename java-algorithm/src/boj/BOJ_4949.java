import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String input = br.readLine();
            if (input.equals(".")) break;        // 먼저 종료 조건 확인

            stack.clear();                       // 줄마다 스택 초기화
            boolean isValid = true;              // 중간 실패 체크용

            char[] line = input.toCharArray();

            for (char c : line) {

                // 여는 괄호만 push
                if (c == '(' || c == '[') {
                    stack.push(c);
                }

                // 닫는 괄호만 검사
                else if (c == ')' || c == ']') {

                    // 스택 비어있으면 실패
                    if (stack.empty()) {
                        isValid = false;
                        break;
                    }

                    // 짝 맞으면 pop, 아니면 실패
                    if (isBalanced(c)) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            // 끝났을 때 스택 비어있고 중간 실패 없으면 yes
            if (isValid && stack.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    // 닫는 괄호가 top과 짝이 맞는지 확인
    public static boolean isBalanced(char c) {
        if (!stack.empty()) {

            char top = stack.peek();

            return (c == ')' && top == '(') || (c == ']' && top == '[');
        }

        return false;
    }
}