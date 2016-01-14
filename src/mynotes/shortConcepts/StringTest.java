package mynotes.shortConcepts;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "some text";
		s1.substring(0,4);//new string created but reference lost
		System.out.println(s1); // still printing "some text"
		String s2 = s1.substring(0,4);
		System.out.println(s2); // prints "some"
		// 2 new object "more" and "text" were created but their references were lost,
		//another new object "more text" was created and its reference assigned to s3
		String s3 = "more" +"text";  
		System.out.println(s3); //prints "more text"
		
		
		String str1 ="abc";
		String str2 ="abc";
		String str3 =new String("abc");
		String str4 = new String("abc").intern();
		System.out.println("str1==str2 ==>"+(str1==str2));
		System.out.println("str1==str3 ==>"+(str1==str3));	
		System.out.println("str1==str3.intern() ==>"+(str1==str3.intern()));
		System.out.println("str1==str4 ==>"+(str1==str4));	
		
		String str ="b";
		int value=0;
		// java 7 only!
		switch (str.toLowerCase()) {
		      case "a":
		           value = 1;
		           break;
		      case "b":
		           value = 2;
		           break;
		}
		System.out.println(value);
	}

}
