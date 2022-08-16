package a0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_김선규 {

	static int N, M;
	static int[] ans, arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// input end
		
		Arrays.sort(arr);
		
		perm(0, 0);
		
		System.out.println(sb);
	}

	public static void perm(int idx, int cnt) {
		if(cnt == M) {
			for(int i : ans)
				sb.append(i+" ");
			sb.append('\n');
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			ans[cnt] = arr[i];
			perm(idx+1, cnt+1);
		}
	}
}
