
import java.io.IOException;
import java.lang.Character;
import java.lang.Math;

public class EncrFilter2 extends Filter{

   public EncrFilter2(Pipe input, Pipe output){
      super(input, output);
   }

   /*-------------------------------------------------------
   /* Read from the input pipe, character by character.
   /* Encrypt the chars by using Encryption Algorithm 2 (���黥���㷨).
   /* Precondition: a text file to be encrypted contains only
   /* English characters and digital numbers. The algorithm is:
   /*       a<-->b, c<-->d, e<-->f, ,..., y<-->z
   /*       0<-->1, 2<-->3, ...8<-->9
   /* Upper case letters are also encrypted the same way
   /* (Upper case letters are encrypted into Upper case letters) .
   /* The encrypted chars are written to the sink pipe char by char
   /*------------------------------------------------------*/
   protected void processData(){

      try{
         int c = inPipe.read(); // Read a character from the source pipe

         while(c != -1){ //not end of file
            char f = (char)c;
			char e = encrypt(f); // to encrypt a character
			outPipe.write(e);  // Write character 'e' to the sink pipe
            c = inPipe.read();
         }
         outPipe.closePipedOutputStream();
         inPipe.closePipedInputStream();
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.err.println("Error: failed encryption 2");
         System.exit(1);
      }
   }
   
   private char encrypt(char c) {
	   System.out.println("\n original char: "+c);
	   char[] digitArr = getDigitArray();
	   char[] alphabet = getAlphabetArray();
	   
	   for(int n = 0;n<26;n++){
		   if(c==alphabet[n]){
			   c = alphabet[(int) (n +Math.pow(-1, n%2))];
			   break;
		   }
		   else if (c == Character.toUpperCase(alphabet[n])) {
			   c = Character.toUpperCase(alphabet[(int)(n + Math.pow(-1,n))]);
			   break;
		   }
		   for(int j=0;j<10;j++){
			   if (c==digitArr[j]){
				   c = digitArr[(int) (j +Math.pow(-1, j%2))];
				   break;
			   }
		   }
		   System.out.println("Encrypted char: "+c);
		   return c;
	   }
	   return c;
   }
   
   private char[] getAlphabetArray(){
       String str = "abcdefghijklmnopqrstuvwxyz";
	   char[] chArray = str.toCharArray();
	   return chArray;
   }
   private char[] getDigitArray(){
       String str = "0123456789";
  	   char[] chArray = str.toCharArray();
  	   return chArray;
   }
   
}


