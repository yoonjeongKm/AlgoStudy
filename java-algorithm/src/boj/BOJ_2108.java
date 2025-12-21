import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;

            //최대값 구하기
            if (max < num) {
                max = num;

            }

            // 최소값 구하기
            if (min > num) {
                min = num;
            }
        }

        Arrays.sort(arr); // 오름차순 정렬

        //빈도수 입력
        for(int x : arr) {
            // arr 값이 키 값인 빈도수가 있으면 꺼내서 +1 없으면 1
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 산술평균 구하기
        System.out.println(Math.round((double) sum / n));
        // 중앙값 구하기
        System.out.println(arr[(n-1) / 2]);
        // 최빈값 구하기
        int maxCount = 0;

        // 최대 빈도수 찾기
        for (int cnt : map.values()) {
            maxCount = Math.max(maxCount, cnt);
        }

        // 최대 빈도수를 가진 값들 모으기
        List<Integer> modes = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                modes.add(key);
            }
        }

        // 정렬
        Collections.sort(modes);

        // 출력
        if (modes.size() == 1) {
            System.out.println(modes.get(0));
        } else {
            System.out.println(modes.get(1)); // 두 번째로 작은 값
        }
        // 최댓값과 최솟값의 차이
        System.out.println(max - min);

    }
}
