package tw.YL;

import java.sql.Connection;
import java.sql.SQLException;

import tw.apis.labUtils;
import tw.apis.Member;
import tw.apis.MemberDAO;
import tw.apis.MemberDAOImpl;

/*
	加入 Transaction（交易機制）
	一組操作要嘛全部成功、要嘛一筆都不執行，可用於會員資料修改（要一起成功）
 */

public class lab78 {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			conn = labUtils.getConnection();
			
//			關閉自動提交，讓整段 SQL 操作變成一個交易
			conn.setAutoCommit(false);
			MemberDAO dao = new MemberDAOImpl(conn);
			
			Member m1 = dao.findById(3);
			Member m2 = dao.findById(6);
			
			m1.setName("333333");
			dao.updateMember(m1);
			
//			模擬錯誤，觸發 rollback()，讓整筆交易取消，達成「錯就全部不做」
			System.out.println(10 / 0);
//			System.out.println(10 / 3);
			
			m2.setName("666666");
			dao.updateMember(m2);
			
			System.out.println("OK");
			
//			如果中間沒出錯就提交交易
			conn.commit();
			
			
		}catch(Exception e) {
			System.out.println(e);
			if (conn != null) {
				try {
					conn.rollback();
					System.out.println("rooback OK");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		}finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}

}