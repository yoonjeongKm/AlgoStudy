import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); // 의견 개수

        int rmNum = (int) Math.round(0.15 * num); // 앞뒤로 제거할 인원

        int first = rmNum + 1; // 평균 계산 시작할 의견
        int last = num - rmNum; // 평균 계산 끝날 의견
        int sum = 0; // 의견 난이도 합

        int[] points = new int[num+1];

        for (int i = 1; i <= num; i++) {
            int point = Integer.parseInt(br.readLine()); // 점수
            points[i] = point;
        }

        Arrays.sort(points); // 점수 오름차순 정렬

        // 의견 합 구하기
        for (int i = 1; i <= last; i++) {
            if(i >= first) {
                sum += points[i];
            }
        }

        double result = (double) sum / (last - first + 1);
        int roundResult = (int) Math.round(result);

        System.out.println(roundResult);

    }
}
