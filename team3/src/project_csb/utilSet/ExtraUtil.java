package project_csb.utilSet;

import java.util.Scanner;

public class ExtraUtil {
	private static ExtraUtil extraUtil = new ExtraUtil();
	private ExtraUtil() {}
	public static ExtraUtil getInstance() {return extraUtil;}
	
	//입력 객체
	private Scanner sc = new Scanner(System.in);
	// 게터
	public Scanner getScInstance() {return sc;}
	// 세터
	public void setScInstance( Scanner sc ) { this.sc = sc;}
	
	
	
	/*
	 	phoneNumberCheck( String phoneNumber )메소드는 인자값으로 문자열(휴대폰 번호)를 받습니다.
	 	그 후 각각의 검사를 진행합니다.
	 	2. 전화번호가 11자리인지
	 	3. 전화번호에 -가 포함 되어있는지
	 	4. 전화번호 앞 세자리에 010이 포함되어 있는지
	 	5. 숫자가 아닌 문자를 입력했는지
	 	한 가지라도 해당될 경우 false를 반환합니다.
	 */
	public boolean phoneNumberCheck( String phoneNumber ) {
		// 유효성 검사
			// 1. 전화번호가 null이면 false
			if(phoneNumber == null)return false;
			// 2. 전화번호가 11자리가 아니라면 false
			if(phoneNumber.length() != 11)return false;
			// 3. 전화번호에 -가 포함 되어있다면 false
			if(phoneNumber.contains("-") )return false;
			// 4. 전화번호에 앞 세개의 문자가 010이 아니라면 false
			if(!"010".equals(				
					""+phoneNumber.charAt(0) + 
						phoneNumber.charAt(1) +
							phoneNumber.charAt(2))				
					) return false;
			
			// 5.
			for(int i = 0; i < phoneNumber.length(); i++) {
	 			// 아스키코드 48 ~ 57은 0부터 9
	 			if(  phoneNumber.charAt(i) > 57 ||  48 > phoneNumber.charAt(i) )
	 				return false;
	 		}
			
			return true;
	}
    
/*
 	===================================================================
 	certNumber() 메소드는 1000부터 9999까지의 난수를 생성합니다.
 	휴대전화 인증번호가 필요할 때 사용합니다.
*/
    // 인증번호 생성 메소드
 	public int certNumber() {
 		int certNumber = (int)((Math.random() * 8999) + 1000 );
 		return certNumber;
 	}
	
 	
 	/*=================================================================
 	 *  비밀번호 유효성 검사 메소드는 인자 값으로 문자열(password)를 받습니다.
 	 *  그 후 각각의 검사를 진행합니다.
 	 *  1. password가 null이 아닌지
 	 *  2. password의 총 길이가 4가 아닌지
 	 *  3. 숫자가 아닌 문자를 입력했는지
 	 */
 	public boolean passwordCheck(String password) {
 		
 		// 1.
 		if(password == null)return false;
 		// 2.
 		if(password.length() != 4)return false;
 		// 3.
 		for(int i = 0; i < password.length(); i++) {
 			// 아스키코드 48 ~ 57은 0부터 9
 			if(  password.charAt(i) > 57 ||  48 > password.charAt(i) )
 				return false;
 		}
 		return true;
 	}

}
