import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0) {
                stack.push(num);
            } else if(!stack.isEmpty()) {
                stack.pop();
            }
        }

        int sum = 0;

        for(int s : stack) {
            sum += s;
        }

        System.out.println(sum);
    }
}
