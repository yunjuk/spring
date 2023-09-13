package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberService {
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST = 0;
	final static public int ADMIN_ACCOUNT_CREATE_SUCCESS =1;
	final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;
	
	@Autowired
	AdminMemberDAO adminMemberDAO;
	public int createAccountConfirm(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMemberService]createAccountConfirm()");
		
	
		boolean isMember = adminMemberDAO.isAdminMember(adminMemberVO.getA_m_id());
		//중복되면 이거 씀 
		//중복 아니면 아래꺼 씀 
		
		if(!isMember) {
			int result = adminMemberDAO.insertAdminAccount(adminMemberVO);
			
			if(result > 0) {
				return ADMIN_ACCOUNT_CREATE_SUCCESS; // return 1; 이라고 해도 무방하지만, 
									//우리가 코드를 읽을 때, 이렇게 정확하게 상수값을 만들어서
									//쓰는 것이 보기 좋기 때문임. 한눈에 이해 가능하게. 
			}else {
				return ADMIN_ACCOUNT_CREATE_FAIL; //return -1;
			}
			}else {
				return ADMIN_ACCOUNT_ALREADY_EXIST;
				
			}
			
		
		
	
		
	}
}
