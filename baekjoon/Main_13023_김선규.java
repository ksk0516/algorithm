import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_13023_김선규 {

	static int N, M, ans;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // [0][0] = 1, [0][1] = 7
			int b = Integer.parseInt(st.nextToken()); // [0][0] = 1, [0][1] = 7

			list[a].add(b); // 1 7
			list[b].add(a); // 7 1
		}

		for (int i = 0; i < list.length; i++) {
			find(i, 0);
			if (ans == 1)
				break;
		}

		System.out.println(ans);
	}

	public static void find(int start, int cnt) { // 4, 1, 1 // 7

		visited[start] = true;

		if (cnt == 4) {

			ans = 1;

			return;
		}

		for (int i = 0; i < list[start].size(); i++) { // 0~2
			if (!visited[list[start].get(i)]) {
				find(list[start].get(i), cnt + 1);
			}
		}
		visited[start] = false;

	}

}
