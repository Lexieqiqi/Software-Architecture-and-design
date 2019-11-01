/*------------------------------------------------*/
/* THis class implements interface MessageLogger  */
/* This class provides a method called            */
/*            logMsg(String msg)                  */
/* to write a message into a file called log.txt  */
/*------------------------------------------------*/

import java.util.*;

public class DBWriter {
   private String lastName;
   private String firstName;
   private String codeNum;
   private String encryptOption;

   private static final String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
   private static final String DBCONNSTR = "jdbc:odbc:AgentInfo";
   private static final String USER = "mikesun";
   private static final String PWORD = "17371";

  public void logMsg(String encryptOption, String lastNm, String firstNm, String code)
  {
	 firstName = firstNm;
	 lastName = lastNm;
	 codeNum = code;
	 this.encryptOption = encryptOption;

	 if(encryptOption.equals(EncryptedInfo1.FOLDING)){
	      String sql = "INSERT INTO EncryptedInfo1 " + "values("  + "'"
	                                   + lastName + "','"
	                                   + firstName + "','"
	                                   + codeNum + "')";
	     DBApplication db = new DBApplication(DBDRIVER, DBCONNSTR, USER, PWORD);
         db.executeInsert(sql);
	 }
     if(encryptOption.equals(EncryptedInfo2.GROUPSWAP)){

		 String sql = "INSERT INTO EncryptedInfo2 " + "values("  + "'"
		 	                                       + lastName + "','"
		 	                                       + firstName + "','"
	                                               + codeNum + "')";
	     DBApplication db = new DBApplication(DBDRIVER, DBCONNSTR, USER, PWORD);
         db.executeInsert(sql);

	 }


  }
}
