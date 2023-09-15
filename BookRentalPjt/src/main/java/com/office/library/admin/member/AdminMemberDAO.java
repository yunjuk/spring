package com.office.library.admin.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component 
public class AdminMemberDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	@Autowired
	PasswordEncoder passwordEncoder;

	
	public boolean isAdminMember(String a_m_id) {
		System.out.println("[AdminMemberDAO] isAdminMemner()");
		
		String sql ="SELECT COUNT(*) FROM tbl_admin_member " + "WHERE a_m_id = ?";
		
		int result = jdbcTemplate.queryForObject(sql, Integer.class, a_m_id);
		
		if(result >0) {
			return true; //중복
		}else {
			return false; //중복되지 않음. 
			
		}
	}
	
	public int insertAdminAccount(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMemberDAO] insertAdminAccount()");
		
		List<String> args = new ArrayList<String>();
		
		String sql = "INSERT INTO tbl_admin_member(";
		if(adminMemberVO.getA_m_id().equals("super admin")) {
			sql += "a_m_approval,";
			args.add("1"); //insert into tbl_admin_member(a_m_approval 에 들어갈 값을 1로 설정한 것
			//1인 경우에는 최고 관리자를 뜻함. 멤버의 성격이 슈퍼 어드민을 가지고 있으면 권한을 1로 설정을 함. 
		} //  값들을 args로 집어넣고 있음. 
		
		//하단의 코드들은 sql구문을 완성하는 것임. 
		//insert into tbl_admin_member(a_m_approval, a_m_id, a_m_pw등 
		//sql 값들을 하나하나 만들고 있음
		
		
		sql += "a_m_id,";
		args.add(adminMemberVO.getA_m_id());
		

		sql += "a_m_pw,";
		args.add(passwordEncoder.encode(adminMemberVO.getA_m_pw()));
		

		sql += "a_m_name,";
		args.add(adminMemberVO.getA_m_name());
		

		sql += "a_m_gender,";
		args.add(adminMemberVO.getA_m_gender());
		

		sql += "a_m_part,";
		args.add(adminMemberVO.getA_m_part());
		

		sql += "a_m_position,";
		args.add(adminMemberVO.getA_m_position());
		
		sql += "a_m_mail,";
		args.add(adminMemberVO.getA_m_mail());
		
		
		sql += "a_m_phone,";
		args.add(adminMemberVO.getA_m_phone());
		
		sql+="a_m_reg_date, a_m_mod_date) " ;
		
		
		if(adminMemberVO.getA_m_id().equals("super admin")) {
			sql+="VALUES(?,?,?,?,?,?,?,?,?,NOW(), NOW())";
		}else {
			sql += "VALUES(?,?,?,?,?,?,?,?,NOW(), NOW())";
		}
		int result = -1;
		
		try {
			
			result = jdbcTemplate.update(sql, args.toArray());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	
	
	public AdminMemberVO selectAdmin(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMemberDAO] selectAdmin()");
		
		String sql = "SELECT * FROM tbl_admin_member " + "WHERE a_m_id = ? AND a_m_approval > 0";
		
		List<AdminMemberVO> adminMemberVOs = new ArrayList<AdminMemberVO>();
		
		
		try {
			adminMemberVOs = jdbcTemplate.query(sql, new RowMapper<AdminMemberVO>() {
				
				@Override
				public AdminMemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminMemberVO adminMemberVO = new AdminMemberVO();
					
					adminMemberVO.setA_m_no(rs.getInt("a_m_no"));
					adminMemberVO.setA_m_approval(rs.getInt("a_m_approval"));
					adminMemberVO.setA_m_id(rs.getString("a_m_id"));
					adminMemberVO.setA_m_pw(rs.getString("a_m_pw"));
					adminMemberVO.setA_m_name(rs.getString("a_m_name"));
					
					adminMemberVO.setA_m_gender(rs.getString("a_m_gender"));
					adminMemberVO.setA_m_part(rs.getString("a_m_part"));
					adminMemberVO.setA_m_position(rs.getString("a_m_position"));
					adminMemberVO.setA_m_mail(rs.getString("a_m_mail"));
					adminMemberVO.setA_m_phone(rs.getString("a_m_phone"));
					adminMemberVO.setA_m_reg_date(rs.getString("a_m_reg_date"));
					adminMemberVO.setA_m_mod_date(rs.getString("a_m_mod_date"));
					
					return adminMemberVO;
				}	
				
			}, adminMemberVO.getA_m_id());
			
			if (!passwordEncoder.matches(adminMemberVO.getA_m_pw(),
				adminMemberVOs.get(0).getA_m_pw()))
				adminMemberVOs.clear();	
		}catch (Exception e) {
			e.printStackTrace();
		} //트라이 캐치문을 써서 종료는 안되고 에러 메시지만 뜨게 됨. 
		return adminMemberVOs.size() > 0 ? adminMemberVOs.get(0) : null;	

		
	}
	public List<AdminMemberVO> selectAdmins(){
		System.out.println("[AdminMemberDAO] selectAdmins()");
		
		
		String sql = "SELECT * FROM tbl_admin_member";
		
		
		List<AdminMemberVO> adminMemberVOs = new ArrayList<AdminMemberVO>();
		
		
		try {
			adminMemberVOs = jdbcTemplate.query(sql, new RowMapper<AdminMemberVO>() {
				
					@Override
						public AdminMemberVO mapRow(ResultSet rs, int rowNum) 
						throws SQLException{
						AdminMemberVO adminMemberVO = new AdminMemberVO();
						
						adminMemberVO.setA_m_no(rs.getInt("a_m_no"));
						adminMemberVO.setA_m_approval(rs.getInt("a_m_approval"));
						adminMemberVO.setA_m_id(rs.getString("a_m_id"));
						adminMemberVO.setA_m_pw(rs.getString("a_m_pw"));
						adminMemberVO.setA_m_name(rs.getString("a_m_name"));
						adminMemberVO.setA_m_gender(rs.getString("a_m_gender"));
						adminMemberVO.setA_m_part(rs.getString("a_m_part"));
						adminMemberVO.setA_m_position(rs.getString("a_m_position"));
						adminMemberVO.setA_m_mail(rs.getString("a_m_mail"));
						adminMemberVO.setA_m_phone(rs.getString("a_m_phone"));
						adminMemberVO.setA_m_reg_date(rs.getString("a_m_reg_date"));
						adminMemberVO.setA_m_mod_date(rs.getString("a_m_mod_date"));
						
						return adminMemberVO;
					}
			  });
				
			}catch (Exception e) {
				e.printStackTrace();
		}
		return adminMemberVOs;
		
		
	}
	public int updateAdminAccount(int a_m_no) {
		System.out.println("[AdminMemberDAO] updateadminAccount()");
		String sql = "UPDATE tbl_admin_member SET "
				+ "a_m_approval = 1 "
				+ "WHERE a_m_no = ? ";
		
		int result = -1;
		
		try {
			result = jdbcTemplate.update(sql, a_m_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
}
