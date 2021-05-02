package algo;

import java.util.*;

public class Main_bj_16463_13일의금요일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String yo[]={"월","화","수","목","금","토","일"};
		int n = sc.nextInt();
		int result=0;
		int d=13;
		int day[] = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for(int i=2019;i<=n;i++) {
			if(is29(i)) {//윤년
				day[2]=29;
			}else {
				day[2]=28;
			}
			for(int j=1;j<=12;j++)//1월 ~12월까지
			{
				if(yo[d%7]=="금")
					result++;
				d+=day[j];
			}
		}
		System.out.println(result);
	}

	// 윤년인지 아닌지 판단
	static boolean is29(int year) {
		if(year%400==0)
			return true;
		else {
			if(year%100==0)
				return false;
			else {
				if(year%4==0)
					return true;
				else {
					return false;
				}
			}
		}
	}
}
