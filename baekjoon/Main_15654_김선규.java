import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_김선규 {

	static int N, M;
	static int[] ans, arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];
		check = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// input end
		
		Arrays.sort(arr); // 1 7 8 9
		
		perm(0);
		
		System.out.println(sb);
	}

	public static void perm(int idx) {
		if(idx == M) {
			for(int i : ans)
				sb.append(i+" ");
			sb.append('\n');
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(check[i])
				continue;
			check[i] = true;
			ans[idx] = arr[i];
			perm(idx+1);
			check[i] = false;
		}
	}
}
