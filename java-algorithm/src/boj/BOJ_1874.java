import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        // 수열 넣기
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        boolean isCorrect = true; //불가능한지 아닌지

        Stack<Integer> stack = new Stack<>();

        int idx = 1; //수열 인덱스
        int num = 1; // 정수 n

        // 수열 끝까지 탐색할때까지
        while (idx <= n) {

            //스택에 비어있으면 스택에 넣기
            if (stack.isEmpty()) {
                sb.append("+").append('\n');
                stack.push(num++);
                continue;
            }

            // 스택 제일위에 있는 값과 수열 값이 같으면 뽑아내기
            if(stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-").append('\n');
                idx++;
            // 스택 제일 위에 있는 값이 수열 값보다 크면 더 이상 불가능이라서 끝
            } else if(stack.peek() > arr[idx]) {
                isCorrect = false;
                break;
            // 스택 제일 위에 있는 값이 수열 값보다 작으면 스택에 쌓기
            } else if(stack.peek() < arr[idx]) {
                stack.push(num++);
                sb.append("+").append('\n');
            }
        }

        if(isCorrect) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}
