import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_김선규 {

	static int N, M;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ans = new int[M];

		comb(1, 0);
	}

	public static void comb(int idx, int cnt) {

		if (cnt == M) {
			for (int i = 0; i < M; i++)
				System.out.print(ans[i] + " ");
			System.out.println();
			
			return;
		}
		for (int i = idx; i <= N; i++) {
			ans[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}
}
