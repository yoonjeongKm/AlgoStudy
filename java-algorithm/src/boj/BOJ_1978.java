import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1978 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 소수 개수
        String[] parts = br.readLine().split(" ");

        int count = 0;

        for(int i = 0; i < n; i++) {

            int a = Integer.parseInt(parts[i]);

            if(a <= 1) continue; // 1 이하 제외

            boolean isPrime = true;

            for(int j = 2; j*j <= a; j++) { // 반절까지만 체크해도 다 확인 가능
                if(a%j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) count++;
        }
        System.out.println(count);
    }
}
