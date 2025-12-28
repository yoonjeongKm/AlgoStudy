import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcases; i++) {

            int num = Integer.parseInt(br.readLine());

            Map<String, Integer> clothes = new HashMap<>();

            for (int j = 0; j < num; j++) {
                String[] kind = br.readLine().split(" ");

                if (!clothes.containsKey(kind[1])) {
                    clothes.put(kind[1], 1);
                } else {
                    clothes.put(kind[1], clothes.getOrDefault(kind[1], 0) + 1);
                }
            }

            int result = 1;

            // 입지 않음 + 옷 종류의 개수
            for(int count: clothes.values()) {
                result *= count + 1;
            }

            // 아무것도 입지 않는 경우는 제외
            System.out.println(result-1);
        }
    }
}
