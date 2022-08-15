import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15651_김선규 {
	
	static int N, M;
	static int[] ans;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = new int[M];
		
		perm(0);
		
		bw.flush();
		bw.close();
	}
	
	public static void perm(int idx) throws IOException {
		if(idx==M) {
			for(int i : ans)
				bw.write(i+" ");
			bw.write('\n');
			
			return;
		}
		
		for(int i=1; i<=N; i++) {
			ans[idx] = i;
			perm(idx+1);
		}
	}

}
