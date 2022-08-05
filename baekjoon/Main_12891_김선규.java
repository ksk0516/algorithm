import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String DNA = br.readLine();
		st = new StringTokenizer(br.readLine());
		int[] acgtF = new int[4];
		for(int i=0; i<acgtF.length; i++)
			acgtF[i] = Integer.parseInt(st.nextToken());
		int ans = 0;
		int res = 0;
		char[] c = {'A', 'C', 'G', 'T'};
		
		// input end
		
		String s = DNA.substring(0, P);
		int[] tmp = new int[4];
		for(int j=0; j<s.length(); j++) {
			if(s.charAt(j)=='A')
				tmp[0]++;
			else if(s.charAt(j)=='C')
				tmp[1]++;
			else if(s.charAt(j)=='G')
				tmp[2]++;
			else if(s.charAt(j)=='T')
				tmp[3]++;
		}
		//임의의 문자열 tmp배열에 개수 넣기 ok
		
		int count=0;
		for(int j=0; j<4; j++) {
			if(acgtF[j]==0)
				count++;
			else if(tmp[j] >= acgtF[j])
				count++;
		}
		
		if(count==4)
			res++;
		//substring과 비교 end
		
		
		for(int j=0, i=P; i<DNA.length(); j++, i++) {
			count=0;
			if(DNA.charAt(j)=='A')
				tmp[0]--;
			else if(DNA.charAt(j)=='C')
				tmp[1]--;
			else if(DNA.charAt(j)=='G')
				tmp[2]--;
			else if(DNA.charAt(j)=='T')
				tmp[3]--;
			
			if(DNA.charAt(i)=='A')
				tmp[0]++;
			else if(DNA.charAt(i)=='C')
				tmp[1]++;
			else if(DNA.charAt(i)=='G')
				tmp[2]++;
			else if(DNA.charAt(i)=='T')
				tmp[3]++;
			//배열의 맨앞자리의 tmp배열값 빼주고 다음에 올 맨 뒷자리 tmp배열값 더해주기!
			
			for(int k=0; k<4; k++) {
				if(acgtF[k]==0)
					count++;
				else if(tmp[k] >= acgtF[k])
					count++;
			}
			//ACGT 4자리를 비교해서 count를 센다. 4자리 모두 조건이 충족된다면 
			
			if(count==4)
				res++;
			//결과값에 1을 더해준다.
		}
		
		
		System.out.println(res);
	}

}

