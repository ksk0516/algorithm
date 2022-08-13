import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
			
		int n = Integer.parseInt(br.readLine());
		//n=Integer.parseInt(st.nextToken());
		int wide = 0;
		int[][] saek = new int[101][101];
		
		for(int z=0; z<n; z++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int i=a; i<a+10; i++) {
				for(int j=b; j<b+10; j++) {
					saek[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(saek[i][j] == 1)
					cnt++;
			}
		}

			
		System.out.println(cnt);
	}

}
