import java.util.*;

public class EncryptedInfo3 implements Encryption{
	private char[] chars;
	private TxtFileWriter writer;
	public static final String CAESARCYPHER = "CaesarCypher";
	
	public EncryptedInfo3(TxtFileWriter writer){
		this.writer = writer;
	}
	public void log(String lastNm, String firstNm, String code){
		 String lName = encryptName(lastNm);
		 String fName = encryptName(firstNm);
         String codeStr = encryptCode(code);
		 ClientGUI.resultTxt.append("Encrypted agent first name: "+ fName +"\n");
		 ClientGUI.resultTxt.append("Encrypted agent last name: "+ lName +"\n");
	     ClientGUI.resultTxt.append("Encrypted agent code: "+ codeStr +"\n\n");

		 writer.logMsg(CAESARCYPHER, lName, fName, codeStr);
		 ClientGUI.resultTxt.append("Data has been saved into file "+ CAESARCYPHER +".txt"+"\n\n");
	 }
	 
	   public String encryptName(String msg){
			  System.out.println(msg);
			  char[] alphabet = getAlphabetArray();
			  char[] chars = msg.toCharArray();

			  System.out.println("CharLen"+chars.length);

			  for (int m = 0; m < chars.length; m++){
			     for(int n = 0; n < 26; n++){
			    	 if ((n==25)&&(chars[m] == alphabet[n])){
				    	   chars[m] = alphabet[0];
				    	   break;
				       }
				       if ( (chars[m] == Character.toUpperCase(alphabet[25]))){
						      chars[m] = Character.toUpperCase(alphabet[0]);
							  break;
				           }
			           if ( chars[m] == alphabet[n]){
			              chars[m] = alphabet[n+1];
			        	  break;
			           }
			           
			           else if ( chars[m] == Character.toUpperCase(alphabet[n]) ){
						      chars[m] = Character.toUpperCase(alphabet[n+1]);
							  break;
				           }
			      }
			  }
			  return new String(chars);
		   }
	
	public String encryptCode (String code){
		char[] digitArr = getDigitArray();
		char[] codeChars = code.toCharArray();
	    char[] alphabet = getAlphabetArray();
		  if(codeChars.length != 12){
			     System.out.println("Incorrect code length.");
			  }
			  else{
			     for (int m = 0; m < codeChars.length; m++){
				    for(int n = 0; n < 26; n++){
				       if ((n==25)&&(codeChars[m] == alphabet[n])){
				    	   codeChars[m] = alphabet[0];
				    	   break;
				       }
				       if ( (codeChars[m] == Character.toUpperCase(alphabet[25]))){
						      codeChars[m] = Character.toUpperCase(alphabet[0]);
							  break;
				           }
			           if ( codeChars[m] == alphabet[n]){
			              codeChars[m] = alphabet[n+1];
			        	  break;
			           }
			           
			           else if ( codeChars[m] == Character.toUpperCase(alphabet[n]) ){
						      codeChars[m] = Character.toUpperCase(alphabet[n+1]);
							  break;
				           }
			        }

		            for(int j = 0; j < 10; j++){
		            	if ( codeChars[m] == digitArr[j] || j==9){
				              codeChars[m] = digitArr[0];
				        	  break;
				           }
			           if ( codeChars[m] == digitArr[j]){
			              codeChars[m] = digitArr[j+1];
			        	  break;
			           }
			        }
			     }
			   }
			   return new String(codeChars);
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
