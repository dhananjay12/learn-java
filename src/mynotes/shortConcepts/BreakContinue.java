package mynotes.shortConcepts;

public class BreakContinue {
	
	 public static void main( String [] args ) {

         for( int i = 0 ; i < 10 ; i++ ) {

               if( i % 2 == 0) { // if pair, will jump
                   continue; // don't go to "System.out.print" below.
               }

               System.out.println("The number is " + i );

               if( i == 7 ) {
                   break; // will end the execution, 8,9 wont be processed
                }

         }
         System.out.println("##########################################");
         
         int[] numbers= new int[]{100,18,21,30};
         
         //Outer loop checks if number is multiple of 2
         OUTER:  //outer label
         for(int i = 0; i<numbers.length; i++){
             if(i % 2 == 0){
                 System.out.println("Odd number: " + i + ", continue from OUTER label");
                 continue OUTER;
             }
           
             INNER://inner label
             for(int j = 0; j<numbers.length; j++){
                 System.out.println("Even number: " + i + ", break  from INNER label");
                 break INNER;
             }
         }

  }

}
