import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15652_김선규 {
	
	static int N, M;
	static int[] ans;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];
		
		perm(1, 0);
		
		bw.flush();
		bw.close();
	}
	
	public static void perm(int idx, int cnt) throws IOException {
		if(cnt==M) {
			for(int i : ans)
				bw.write(i+" ");
			bw.write('\n');
			
			return;
		}
		
		for(int i=idx; i<=N; i++) {
			ans[cnt] = i;
			perm(i, cnt+1);
		}
	}

}
