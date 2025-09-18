package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String sqlSeller = "SELECT * From seller";
		String UpdateSeller = "UPDATE seller SET BaseSalary = ? WHERE DepartmentId = ?";
		Connection conn = null;
		PreparedStatement st = null;

		try (Scanner sc = new Scanner(System.in)) {
			conn = DB.getConnection();
			st = conn.prepareStatement(UpdateSeller);

			conn.setAutoCommit(false);

			while (true) {
				System.out.print("Enter Department id for salary increase(1 - 4): ");
				int departmentId = sc.nextInt();
				System.out.print("Enter percentage: ");
				double percentage = sc.nextDouble();

				st.setDouble(1, percentage);
				st.setInt(2, departmentId);
				
				int rowsAffected = st.executeUpdate();
				
				System.out.println();
				System.out.println("Done! Rows affected: " + rowsAffected);
				
				System.out.print("Continue? (y/n) ");
				char resp = sc.next().charAt(0);
				if (resp == 'n') {
					break;
				}
				
				conn.commit();
			}

			ResultSet rs = st.executeQuery(sqlSeller);
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + " - " + rs.getString("Name") + ", "
						+ String.format("%.2f", rs.getDouble("BaseSalary")));
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("ERRO: Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

}
