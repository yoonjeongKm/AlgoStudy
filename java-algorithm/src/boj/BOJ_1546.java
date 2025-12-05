import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] subject = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = 0;
        double sum = 0;

        // 과목 최대값 구하기
        for (int i = 0; i < n; i++) {
            max = Math.max(max, subject[i]);
        }


        // 과목 점수 재계산
        for (int i = 0; i < n; i++) {
            sum += (double) subject[i] / max * 100;
        }

        System.out.println(sum / n);

    }
}
