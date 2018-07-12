package test;
import java.sql.*;
import java.util.*;
public class JDBCTest {//실제 dao는 메인 없음, 연습용
	public static void main(String[] args) {
		try {//트라이로 영역을 주고 Class.forName(이름)을 주면 이 영역은 이름객체 안이야 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 클래스파일이 없는 인스턴스를 만든다(동적(클래스파일로남지않는)으로 생성) == 리플렉션이라고 하나봄
			//오라클드라이버라는객체가만들어진거다 이게 있어야 드라이버매니저가 동작한다.
			// 클래스가 나를 부르는 방식으로 객체 생성, 생성자 & 싱글톤이 아닌
			//호출했는데 리턴받는 값이 없다. 오라클객체가 자기자신을 호출하는 느낌
			//여기 내부는 오라클드라이버영역이라고 생각해야한다.
			Connection conn = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
							,"seein"
							,"0158");
			//String sql = "SELECT COUNT(*) AS count FROM TAB";
			String sql = "SELECT * FROM TAB";
			Statement stmt = conn.createStatement();
			// stmt는 오라클의 양식에 맞는 양식지 위에다가 쿼리를 올려놓기 위해서 사용
			// conn이 전달받을 쿼리 방을 하나 만들면 그 방의 위치값을 stmt가 가지고
			ResultSet rs = stmt.executeQuery(sql);
			// stmt가 방에  쿼리를 집어넣으면 그 쿼리의 실행 결과는 rs에 담긴다.
			// rs는 디비에서 값을 받은담에 빠르게 담기만 하는것. 분류는 나중에 한다. 일단 빠르게 담아
			
			List<String> table = new ArrayList<>();
			while(rs.next()) {
				table.add(rs.getString("TNAME"));//메타데이터 이름중 하나
				
			}
			System.out.println(table);
			/*
			String count = "";
			while(rs.next()) {// 끝을 모르니 rs 개수 끝까지 조건 걸고 처리
				//count = rs.getString("count"); // getString은 column의 메타데이터(속성명,알리아스)를 가져옴
				count = rs.getString("STA"); // getString은 column의 메타데이터(속성명,알리아스)를 가져옴
			}
			System.out.println(count); // 테이블 수 출력
		*/	
		} catch (SQLException e) {
			System.out.println("에러발생");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		/*String sql = "SELECT * FROM TAB";
		try { // 이 스콥 내의 걸 끝내고 conn부터 다해서 스콥내의 객체 다 지워버림 가비지컬렉터가
			//지우고 try 윗줄로 올라가서 대기
			Connection conn = DriverManager.getConnection("연결","아이디","비번");
			conn은 메모리(ram)에 있는데 하드디스크(드라이버) 까지 가야함 먼길이야
			이를 드라이버매니저가 관리해줌(하드디스크까지 연결)   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ 
	}
}
