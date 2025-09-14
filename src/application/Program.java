package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		String sqlDepartment = "SELECT * From department";
		String sqlSeller = "SELECT * From seller";
		
		try (Connection conn = DB.getConnection();
				Statement st = conn.createStatement()){
			
			try (ResultSet rs = st.executeQuery(sqlDepartment)){
				System.out.println("------DEPARTMENT------");
				while (rs.next()) {
					System.out.println(rs.getInt("id") 
							+ " - " + rs.getString("Name"));
				}
			}
			
			try (ResultSet rs = st.executeQuery(sqlSeller)){
				System.out.println("------SELLER------");
		        while (rs.next()) {
		            System.out.println(
		                rs.getInt("Id") + " - " + rs.getString("Name") +
		                " - " + rs.getString("Email") +
		                " - " + rs.getDate("BirthDate") +
		                " - " + rs.getDouble("BaseSalary") +
		                " - " + rs.getInt("DepartmentId")
		            );
		        }
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
