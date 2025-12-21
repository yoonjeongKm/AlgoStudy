import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 소수인지 아닌지 체크
        boolean[] isPrime = new boolean[n+1];

        // 2부터는 우선 소수라고 가정
        for(int i=2; i<=n; i++){
            isPrime[i] = true;
        }

        //i의 배수들을 소수에서 제거하기(m 이전까지만 체크)
        for(int i = 2; i * i <= n; i++){

            // 이미 소수가 아니라고 판명된 값들은 넘어가기
            if(!isPrime[i]) continue;

            // i*i 부터 시작하는 이유 그전은 이미 다 체크됐을거라서
            // j += i 는 i의 배수들 체크하기 위한 로직
            for(int j = i * i; j <= n; j += i ){
                isPrime[j] = false; // 소수가 아님
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = m; i <= n; i++){
            if(isPrime[i]) sb.append(i).append('\n');
        }

        System.out.print(sb);

    }
}
