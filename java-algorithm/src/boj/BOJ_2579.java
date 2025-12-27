import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 예외 처리
        if (N == 1) {
            System.out.println(score[1]);
            return;
        }
        if (N == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }

        // 초기값
        dp[1] = score[1];
        dp[2] = score[1] + score[2];
        dp[3] = Math.max(
                score[1] + score[3],
                score[2] + score[3]
        );

        // DP 진행
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(
                    dp[i - 2] + score[i],                 // 2칸 점프
                    dp[i - 3] + score[i - 1] + score[i]   // 1칸 + 1칸
            );
        }

        System.out.println(dp[N]);
    }
}
