package a0419_algo;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution_5607_조합 {
	static final int mod=1234567891;
	public static void main(String[] args)throws Exception {
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			int r=sc.nextInt();
			long fac[]=new long[n+1];
			fac[0]=1;
			for(int i=1;i<=n;i++)
				fac[i]=(fac[i-1]*i)%mod;
			
			long bot=(fac[r]*fac[n-r])%mod;
			long rebot=fermat(bot, mod-2);
			System.out.println("#"+t+" "+(fac[n]*rebot)%mod);
		}


	}
	static long fermat(long n,int x) {
		if(x==0)return 1;
		long tmp=fermat(n,x/2);
		long ret=(tmp*tmp)%mod;
		if(x%2==0)return ret;
		else 
			return (ret*n)%mod;
	}
	
}
