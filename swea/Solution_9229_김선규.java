import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 1,000
			int M = Integer.parseInt(st.nextToken()); // 2,000,000
			st = new StringTokenizer(br.readLine());
			int[] snack = new int[N];
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			//input end
			int sum = 0;
			int max = 0;
			for(int i=0; i<snack.length-1; i++) {
				for(int j=i+1; j<snack.length; j++) {
					sum = snack[i] + snack[j];
					if(sum <= M)
						max = (max < sum) ? sum : max;
				}
			}
			
			if(max == 0)
				System.out.println("#"+tc+" "+(-1));
			else
				System.out.println("#"+tc+" "+max);
		}
	}
}
