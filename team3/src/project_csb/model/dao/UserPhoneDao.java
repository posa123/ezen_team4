package project_csb.model.dao;


import java.lang.reflect.Array;
import java.util.ArrayList;

import project_csb.database.ConnectJdbc;
import project_csb.model.dto.UserPhoneDto;

//유저 핸드폰 dao
public class UserPhoneDao extends ConnectJdbc {
	// 싱글톤
	private static UserPhoneDao dao = new UserPhoneDao();
	private UserPhoneDao() {}
	public static UserPhoneDao getInstance() {return dao;}	
	
	public ArrayList<Integer> invoiceNumber(String phoneSession){
		// 배열선언하는이유는 유저가 전화번호를 입력했을때 배송상태/송장번호가 여러개 일수있기때문에 그갯수만큼 넣는다 
			// 배열선언을 해주지않으면 여러개의 배송정보를 부를수가없다.
		ArrayList<Integer> invoicelist = new ArrayList<>(); 
		try {
			// SQL작성한다
				// 송장번호를 보기위해 , 배송상태를 확인하기위해 유저핸드폰번호를 입력한다.
			String sql = "select InvoiceNumber from Delivery_status where Customer_phone_numbe = ? ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 레코드값이 몇개인지 모르기 때문에 while문 사용
			while(rs.next()) {	
				// 배열안에 넣는다
				invoicelist.add(rs.getInt(1));
				
			}// w e	
		}catch (Exception e) {System.out.println(e);}
		return invoicelist;
	}
	
	// 배송상태확인/출력
	public int deliveryStatus() {
		
		try {
			// 1. sql작성
			String sql = "select delivery_status from Delivery_status where InvoiceNumber = ?";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// true = 1  false = 2  Error = 0 
			// 먀냐게 반환값이 true면 배송완료  반환값이 false면 배송중 반환값이 Error면 실패 
			// delivery_status 는 배달중 배달완료 이기때문에 getBoolean 타입이들어간다 
			if(rs.next()) {rs.getBoolean(1);} 
			if(rs.next()) {rs.getBoolean(2);} 
			if(rs.next()) {rs.getBoolean(3);} 
			
			
		}catch (Exception e) {System.out.println(e);}
		
		
		return 1;
	}
	
}// class e










