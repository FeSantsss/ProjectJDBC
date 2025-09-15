package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String sqlSeller = "SELECT * From seller";
		String updateSeller = "UPDATE seller SET BaseSalary = BaseSalary + ? WHERE Id = ?";
		
		
		try (Connection conn = DB.getConnection();
				PreparedStatement st = conn.prepareStatement(updateSeller);
				Scanner sc = new Scanner(System.in)){
			
			System.out.print("Adicione o ID de identificação do vendedor: ");
			int id = sc.nextInt();
			System.out.print("Adicione o aumento do salário: ");
			double percentage = sc.nextDouble();
			
			st.setDouble(1, percentage);
			st.setInt(2, id);
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected != 0) {
				System.out.println("Feito! Linhas afetadas: " + rowsAffected);
			}else {
				System.out.println("A mudança não foi concedida!");
			}
			
			ResultSet rs = st.executeQuery(sqlSeller);
			while (rs.next()) {
				System.out.println(rs.getInt("Id") 
						+ " - " + rs.getString("Name") 
						+ ", " + String.format("%.2f", rs.getDouble("BaseSalary")));
			}
			
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
