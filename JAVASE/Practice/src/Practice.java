
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	byte[] b= {1,2,3};
    	String s3=new String(b);
    	System.out.println(s3);
    	String s1="abc";  
    	String s2="abchgb";
    	System.out.println(s1.charAt(2));//
    	System.out.println(s1.concat(s2));
    	System.out.println(s1.getBytes());
    	System.out.println(s1.indexOf("c"));
    	System.out.println(s2.lastIndexOf("b"));
    	System.out.println(s1.length());
    	System.out.println(s1.replace('c','b'));
    	String s5="a-b-c";
    	String[] s6=s5.split("-");
    	for(int i=0;i<s6.length;i++) {
    		System.out.print(s6[i]);
    	}
    	System.out.println(s1.indexOf("ac"));
    	System.out.println(s1.substring(1,3));
    	System.out.println(s5.length());
    	StringBuffer buffer=new StringBuffer("xx");
    	buffer.append("ab");
    	buffer.insert(1, "adc");
    	System.out.println(buffer);
    	
    	System.out.println(buffer.reverse());*/
		//第一
		String s = "aAbBcC1adc23dDadc";
		String s1= "aAbBcC1adc23dDadc";
		string1(s);
    	//二、
		System.out.println(string2("adc",s));
		//3
		string3(s,s1);
		//4
		StringBuffer buffer=new StringBuffer("test");
		System.out.println(buffer.reverse());
		//5
		String s3="jdk";
		System.out.println(s3.toUpperCase());
		System.out.println(s3.substring(1));
		//6
		String s4="abaa";
		string4(s4);
		//7
		String s5="113@ ere qqq yyui";
		String s6=s5.replace("@", "");
		String[] s7=s6.split(" ");
		for (int i = 0; i < s7.length; i++) {
			System.out.println(s7[i]);
		}
    	
		
		
		//8
		String s8="to be or not to be";
		String[] s9=s8.split(" ");
		
		for (int i = 0; i < s9.length; i++) {
			StringBuffer buffer1=new StringBuffer(s9[i]);
			buffer1.reverse();
			
			System.out.print(buffer1+" ");
			
		}
		System.out.println("");
		//9
		String s10="name=zhangsan age=18 classNo=090728";
		String[] s11=s10.split(" ");
		
		String[][] s12=new String[3][];
		for (int i = 0; i < s11.length; i++) {
			s12[i]=s11[i].split("=");
			System.out.println(s12[i][1]);
		}
	}
	
	
	
	
	
	
	public static void string4(String s) {
		int n = s.length()/2,m=0;
		for(int i = 0;i<=n;i++) {
			char b=s.charAt(i);
			char d=s.charAt(n);
			if(b!=d) {
				m=m+1;
			}
			n--;
		}
		if(m==0) {
			System.out.println("不对称");
		}else {
			System.out.println("对称");
		}
		
		
	}
	
	public static void string3(String s,String s1) {
		int a = 0;
		
		for(int i = 0;i<s1.length();i++) {
			char b =s.charAt(i);
			char d = s1.charAt(i);
			if(b!=d) {
				a=a+1;
			}
			
		}
		if(a!=0) {
			System.out.println("不相同");
		}else {
			System.out.println("相同");
		}
	}
	
	

	public static int string2(String b,String s) {
		int a=0;
		for(int i =0;i<s.length();i++) {
			int num = s.indexOf(b);
			if(num>0) {
				s=s.substring(num+b.length());
				a=a+1;
			}else {
				return a;
			}
			
		}
		return a;
	}
	
	
	
	
	
	
	public static void string1(String s) {
		String b="";String d ="",e="";
		for(int i =0;i<s.length();i++) {
			char c = s.charAt(i);
			int a = Integer.valueOf(c);
			if(a>=65&&a<=90) {
				b=b+c;
			}else if(a>=97&&a<=122) {
				d=d+c;
			}else {
				e=e+c;
			}
			
			
		}
		System.out.println("大写字母"+b);
		System.out.println("小写字母"+d);
		System.out.println("非字母"+e);
	}

	
	
	
	
	
	
}
