import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1929_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] primeCheck = new boolean[N+1];

		// 아리스토테네스의 체를 이용해 소수인지 판별하자
		primeCheck[0] = primeCheck[1] = true;
		
		for (int j = 2; j * j <= N; j++) {
			for (int k = j * j; k <= N; k += j) {
				primeCheck[k] = true;
			}
		}

		for(int i=M; i<=N; i++) {
			if(!primeCheck[i])
				System.out.println(i);
		}
	}

}
