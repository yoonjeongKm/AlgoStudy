import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] people = new int[N][2];
        int[] rank = new int[N];

        // 입력
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(s[0]); // 몸무게
            people[i][1] = Integer.parseInt(s[1]); // 키
        }

        // 모든 사람을 서로 비교하여 등수를 매기기
        for (int i = 0; i < N; i++) {

            // 자기보다 몸무게 키 모두 큰 사람이 몇 명인지 세기
            int count = 0;

            for (int j = 0; j < N; j++) {

                // i == j 이면 같은 사람, 비교할 필요 없음
                if (i == j) continue;

                // 덩치가 더 큰 사람 찾기
                // 조건: 몸무게도 큼 AND 키도 큼
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    count++; // i보다 덩치 큰 사람 발견 → count 증가
                }
            }

            // 자기보다 덩치 큰 사람 수 + 1 이 자신의 등수
            rank[i] = count + 1;
        }

        for (int r : rank) {
            System.out.print(r + " ");
        }
    }
}
