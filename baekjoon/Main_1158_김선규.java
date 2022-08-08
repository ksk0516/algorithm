import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) list.add(i);
		//input end
		
		int i = K - 1; 
		int cnt = 0;
		
		sb.append("<");
		while (true) {
			if (i < N) {
				sb.append(list.remove(i));
				i--;
				cnt++;
				if (cnt == N) break;
				sb.append(", ");
				i += K;
				if (i >= list.size()) i = i % list.size();
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}