package mynotes.java8.features;

interface A
{
static String method1()
{
return "Static method from interface";
}
}
 
class X implements A
{
}
 
public class TestInterfaceStatic
{
public static void main(String[] args)
{
A.method1();
//X.method1(); // won't compile
}
}
