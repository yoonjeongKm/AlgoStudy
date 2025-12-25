import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int listen = Integer.parseInt(info[0]); // 듣도 못한 사람 수
        int see = Integer.parseInt(info[1]); // 보도 못한 사람 수

        // Set : 중복 비허용
        Set<String> listenInfo = new HashSet<>(); //  듣도 못한 사람 명단
        Set<String> seeInfo = new TreeSet<>(); // 자동 정렬

        // 듣도 못한 사람들 저장하기
        for (int i = 0; i < listen; i++) {
            String name = br.readLine(); // 듣도 못한 사람 이름
            listenInfo.add(name);
        }

        StringBuilder st = new StringBuilder();

        // 보도 못한 사람 이름이 듣도 못한 사람 명단과 중복될때
        for (int i = 0; i < see; i++) {
            String name = br.readLine();

            if (listenInfo.contains(name)) {
                seeInfo.add(name);
            }
        }

        st.append(seeInfo.size()).append("\n");
        for (String name : seeInfo) {
            st.append(name).append("\n");
        }

        System.out.println(st);

    }
}
