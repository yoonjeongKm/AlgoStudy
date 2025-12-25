import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]); //종류
        int k = Integer.parseInt(info[1]); // 가치의 합

        int[] coinValues = new int[n]; // 동전 가치

        for (int i = 0; i < n; i++) {
            coinValues[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;

        for (int i = n-1; i >= 0; i--) {
            int result = countCoins(i, k, coinValues);

            // 결과값이 0이 아닌 최소값 구하기
            if(result != 0) {
                min = Math.min(min, result);
            }
        }

        System.out.println(min);
    }

    public static int countCoins(int index, int sum, int[] coinValues) {

        int count = 0; // 인덱스의 최소값 구하기

        // 코인 배열 전부 검사할때까지
        while (index >= 0) {
            sum -= coinValues[index]; // 해당 코인 가치 가치합에서 빼기
            count++; // 동전 사용 횟수 +1

            if (sum == 0) { // 0이면 도달 완료로 끝
                break;
            } else if(sum < 0) { // 가치가 음수가 되면 잘못된 사용법
                sum += coinValues[index]; // 되돌리기
                index--; // 그 아래 작은 동전 사용
                count--; // 되돌리기
            }
        }

        if (count == 0) { // 끝난후 코인 사용 횟수 없을때
            return 0;
        } else { // 나머지는 코인 사용 횟수 알려줌
            return count;
        }
    }
}
