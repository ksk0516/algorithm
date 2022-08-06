import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {

	static int N = 9;
	static int R = 7;
	static int[] nans = new int[9];
	static int[] ans = new int[7];
	static boolean[] isSelected = new boolean[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < nans.length; i++) {
			nans[i] = Integer.parseInt(br.readLine());
		}
		// input end

		perm(0);
	}

	private static void perm(int cnt) {
		if (cnt == 7) {
			int sum = 0;
			for(int i : ans)
				sum+=i;
			
			if(sum==100) {
				Arrays.sort(ans);
				System.out.println(Arrays.toString(ans));
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			ans[cnt] = nans[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;			
		}

	}

}
