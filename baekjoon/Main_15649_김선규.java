import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_김선규 {

	static int N, M;
	static int[] ans;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];
		check = new boolean[N + 1];

		perm(0, 0);
	}

	public static void perm(int idx, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
			
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (check[i])
				continue;
			check[i] = true;
			ans[idx] = i;
			perm(idx+1, cnt + 1);
			check[i] = false;
		}
	}
}
