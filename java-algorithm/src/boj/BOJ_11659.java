import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 수의 개수
        int m = Integer.parseInt(input[1]); // 합을 구해야 하는 횟수
        String[] numbers = br.readLine().split(" ");

        //누적합
        int[] numSum = new int[n+1];

        for (int i = 1; i <= n; i++) {
            numSum[i] = numSum[i-1] + Integer.parseInt(numbers[i-1]);
        }

        for (int i = 0; i < m; i++) {

            int result = 0;

            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0])-1;
            int end = Integer.parseInt(info[1]);

            result = numSum[end] - numSum[start];

            System.out.println(result);
        }
    }
}
