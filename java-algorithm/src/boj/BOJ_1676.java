import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger number = BigInteger.ONE;

        // 팩토리얼 계산
        for (int i = 1; i <= N; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }

        String numberS = String.valueOf(number);
        int count = 0; // 처음 0이 아닌 숫자가 나올 때까지 0의 개수

        for (int i = numberS.length()-1; i >= 0; i--) { // 뒤에서부터 탐색
            if (numberS.charAt(i) == '0') {  // 0일 경우 카운트 +1
                count++;
            } else { // 0이 아닌 경우 탐색 종료
                break;
            }
        }
        System.out.println(count);
    }
}
