package com.mynotes.examples.java17.multilineStrings;

public class Example {

    static String before(){

        String mystring = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";

        return mystring;
    }

    static String after(){

        String mystring = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
        return mystring;
    }

    public static void main(String[] args) {
        System.out.println("==BEFORE==");
        System.out.println(before());
        System.out.println("==AFTER==");
        System.out.println(after());


    }
}
