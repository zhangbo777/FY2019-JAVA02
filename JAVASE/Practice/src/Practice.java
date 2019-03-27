
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] b= {1,2,3};
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
    	
    	System.out.println(buffer.reverse());
    	
	}

}
