import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int k = Integer.parseInt(info[0]); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(info[1]); // 필요한 랜선의 개수
        long right = 0;
        int[] arrK = new int[k]; // 랜선 길이 배열

        for (int i = 0; i < k; i++) {
            arrK[i] = Integer.parseInt(br.readLine());
            right = Math.max(arrK[i], right);
        }

        long left = 1;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long que = 0;
            for (int i = 0; i < k; i++) {
                que += arrK[i] / mid;
            }

            if(que >= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
