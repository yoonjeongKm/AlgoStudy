import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 갯수

        for (int i = 0; i < N; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = br.readLine().toCharArray();
            boolean correct = true;

            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '(') {
                    stack.push('(');
                } else if (chars[j] == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        correct = false;
                        break;
                    }
                }
            }
            if (correct && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
