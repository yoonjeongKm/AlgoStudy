import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int site = Integer.parseInt(info[0]); // 사이트 주소 수
        int password = Integer.parseInt(info[1]); // 비밀번호를 찾으려는 사이트 주소의 수

        Map<String, String> siteMap = new HashMap<>();

        for (int i = 0; i < site; i++) {
            String[] siteInfo = br.readLine().split(" ");
            siteMap.put(siteInfo[0], siteInfo[1]); // 사이트 주소와 비밀번호 삽입
        }

        for (int i = 0; i < password; i++) {
            String find = br.readLine();

            System.out.println(siteMap.get(find));
        }
    }
}
