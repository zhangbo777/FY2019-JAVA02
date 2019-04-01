package com.neuedu;

public class Classhomework {
	public static void main(String[] args) {
		String s="1,2;3,4,5;6,7,8";
		 
		String[][] twoarray=new String[3][];
		twoarray[0]=new String[2];
		twoarray[1]=new String[3];
		twoarray[2]=new String[3];
		String[] s1=s.split(";");
		double[][] two1=new double[3][];
		
		two1[0]=new double[2];
		two1[1]=new double[3];
		two1[2]=new double[3];
		for(int i =0;i<twoarray.length;i++) {		
			twoarray[i]=s1[i].split(",");
			
		}
		double ss=Double.valueOf(twoarray[2][2]);
		System.out.println(ss);
		/*for(int i =0;i<twoarray.length;i++) {
			for(int j =0;i<twoarray[i].length;j++) {
				twoarray[i][j]=parseInt(twoarray[i][j]);
			}
		}*/
	/*	for(int i =0;i<twoarray.length;i++) {
			for(int j =0;i<twoarray[i].length;j++) {
				//Integer aa=new Integer(twoarray[i][j]);
				double ss=Double.valueOf(twoarray[i][j]);
				System.out.println(ss);
				two1[i][j]=ss;
			}
		}
*/
		/*for(int i =0;i<two1.length;i++) {
			for(int j =0;i<two1[i].length;j++) {
				System.out.println("twoarray["+i+"]["+j+"]="+two1[i][j]);
			}
		}
		*/
		
		
		
		
		
		
		//随机数10-20之间
		/*for(int i =0;i<10;i++) {
			int randow1=(int) (Math.random()*10+10);
			System.out.println(randow1);
		}*/
		
	}
}

