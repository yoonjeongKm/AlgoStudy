import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]); // 카드 개수
        int m = Integer.parseInt(nm[1]); // 카드의 최대합

        int max = 0;

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0 ; i < n-2 ; i++) {
            for(int j = i + 1 ; j < n - 1 ; j++) {
                for(int k = j + 1 ; k < n ; k++) {
                    int numSum = nums[i] + nums[j] + nums[k];

                    if(numSum <= m) {
                        max = Math.max(max, numSum);
                    }
                }
            }
        }

        System.out.println(max);

    }
}
