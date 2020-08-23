package step04.myart.lbh;

public class MyArt {
	private static MyArt instance = new MyArt();
	
	private MyArt() {
	}
	
	public static MyArt getInstance() {
		return instance;
	}
	public String fid(String myName, String yourName) {
		
		int f1 = myName.codePointAt(0);
		int f2 = yourName.codePointAt(0);
	    int abs = (f1-f2);
	    int result = f1 - abs;
	    char s = (char)result;
	    
	    int f3 = myName.codePointAt(1);
	    int f4 = yourName.codePointAt(1);
	    int abs2 = (f3-f4);
	    int result2 = f3 - abs2;
	    char s2 = (char)result2;
	    System.out.println(s2);
	    
	    int f5 = myName.codePointAt(2);
	    int f6 = yourName.codePointAt(2);
	    int abs3 = (f5-f6);
	    int result3 = f5 - abs3;
	    char s3 = (char)result3;
	    System.out.println(s3);
	    String s4 = ""+s + s2 + s3;
		return s4;
	}


	
}
