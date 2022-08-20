package a0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_김선규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int originN = N;

		int cnt3 = 0, cnt5 = 0;

		if (N % 5 == 0)
			System.out.println(N / 5);
		else {
			while (N > 5) { // N = 36
				N -= 5;
				cnt5++;
			} // N이 예를들면 1가 되었다. cnt5는 7

			// 5씩 더해가며 3으로 나눠떨어지는지 확인. 근데 계속 안되서 N보다 커지면 -1 출력
			while (originN >= N) { // 36 > 31
				if (N % 3 == 0) {
					cnt3 = N / 3;
					System.out.println(cnt3 + cnt5);
					break;
				}
				N += 5;
				cnt5--;

			}
			
			if(originN < N)
				System.out.println(-1);
		}

	}

}
