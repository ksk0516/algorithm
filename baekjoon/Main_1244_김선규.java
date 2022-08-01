import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_김선규 {
	static int[] swc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		swc = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			swc[i] = Integer.parseInt(st.nextToken());
		int student = Integer.parseInt(br.readLine());
		for(int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine());
			int who = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			int where = number - 1;
			
			//남학생
			if(who==1) { 
				while(where < n) {
					change(where);
					where += number;
				}
			} 
			
			//여학생
			else { 
				int j=1;
				int start=-1;
				int end=0;
				while(where-j >= 0 && where+j < n) {
					if(swc[where-j] == swc[where+j]) {
						start = where-j;
						end = where+j;
					} else {
						break;
					}
					j++;
				}
				if(start==-1)
					change(where);
				else {
					for(int k=start; k<=end; k++) {
						change(k);
					}
				}
			}
		}
		
		//최종 스위치 배열 출력
		for(int i=0; i<n; i++) {
			if(i!=0 && i%20==0)
				System.out.println();
			System.out.print(swc[i]+" ");
		}
	}
	
	//switch 0과 1 바꾸는 메서드
	public static void change(int n) {
		if(swc[n] == 0)
			swc[n] = 1;
		else
			swc[n] = 0;
	}
}