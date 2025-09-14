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
		String sqlDepartment = "SELECT * From seller";
		String sqlInsertSeller = 
				"INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try (Connection conn = DB.getConnection();
				PreparedStatement st = conn.prepareStatement(sqlInsertSeller);
				Scanner sc = new Scanner(System.in)){
			
			while (true) {
				System.out.print("Deseja adicionar um vendedor novo? (s/n) ");
				char addOrNotSeller = sc.next().toLowerCase().charAt(0);
				if (addOrNotSeller == 'n') {
					break;
				} else {
					System.out.print("Digite o nome: ");
					sc.nextLine(); 
					String name = sc.nextLine();
					System.out.print("Digite o email: ");
					String email = sc.next();
					
					System.out.print("Digite a data de nascimento (YYYY-MM-DD): ");
					String birthDate = sc.next();
					java.util.Date date = sdf.parse(birthDate);
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					System.out.print("Digite o salario base: ");
					double baseSalary = sc.nextDouble();
					System.out.print("Digite o ID do departamento (1 a 4): ");
					int departmentId = sc.nextInt();
					
					st.setString(1, name);
					st.setString(2, email);
					st.setDate(3, sqlDate);
					st.setDouble(4, baseSalary);
					st.setInt(5, departmentId);
					
					int rowsAffected = st.executeUpdate();
					
					System.out.println();
					
					System.out.println("Done! Rows affected: " + rowsAffected);
					
					System.out.println();
					
					try (Statement st2 = conn.createStatement();
							ResultSet rs = st2.executeQuery(sqlDepartment)) {
						while (rs.next()) {
							System.out.println(rs.getInt("Id") 
									+ " - " + rs.getString("Name") 
									+ ", " + rs.getString("Email")
									+ ", " + sdf.format(rs.getDate("BirthDate")) 
									+ ", " + rs.getDouble("BaseSalary")
									+ ", " + rs.getInt("DepartmentId"));
						}
					}
				}
			}
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
