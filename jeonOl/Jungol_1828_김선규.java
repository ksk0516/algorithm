package a0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Jungol_1828_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] refri = new int[N][2];
		boolean[] check = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			refri[i][0] = Integer.parseInt(st.nextToken());
			refri[i][1] = Integer.parseInt(st.nextToken());
		}
		// input end

		Arrays.sort(refri, new Comparator<int[]>() { // 2차원 배열 오름차순으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int need = 1; // 필요 냉장고 개수

		for (int i = 0; i < N; i++) {
			if(check[i]) continue;
			
			int min = refri[i][0];
			int max = refri[i][1];

			for (int j = i + 1; j < N; j++) {
				if(refri[j-1][1] < refri[j][0]) {
					need++;
					break;
				}
				
				if (refri[j][0] <= max) {
					check[j] = true;
				}
				else {
					need++;
					break;
				}
			}
		}

		System.out.println(need);
	}

}
