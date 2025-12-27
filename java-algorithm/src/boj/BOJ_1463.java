import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        // dp[i] = i를 1로 만드는 최소 연산 횟수
        int[] dp = new int[n+1];

        dp[1] = 0; // 1은 이미 1이므로 0회

        for(int i=2; i<=n; i++){

            // 1) 일단 "1 빼기"를 기본으로 깔고 시작
            dp[i] = dp[i-1] + 1;

            // 2) 2로 나누어 떨어지면, i/2에서 오는 경우도 비교
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }

            // 3) 3으로 나누어 떨어지면, i/3에서 오는 경우도 비교
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }

        }

        System.out.println(dp[n]);

    }
}
