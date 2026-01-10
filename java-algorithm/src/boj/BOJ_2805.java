import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무 개수
        long m = Long.parseLong(st.nextToken()); // 필요한 나무 길이

        Long[] trees = new Long[n];

        st = new StringTokenizer(br.readLine());
        long max = 0;

        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long left = 0;
        long right = max;
        long answer = 0;

        while(left <= right) {
            long mid  = (left + right) / 2; // 절단 높이

            long sum = 0; // 잘린 나무 총 길이

            for (long h : trees) {
                if(h >= mid) {
                    sum += (h- mid);
                }
            }

            // 나무가 충분하면 → 더 높게 잘라도 됨
            if(sum >= m) {
                answer = mid;
                left = mid + 1;
            // 부족하면 → 더 낮게 잘라야 함
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
