package src.application;

import java.util.Locale;
import java.util.Scanner;

import src.model.dao.DepartmentDao;
import src.model.dao.FactoryDao;
import src.model.dao.SellerDao;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SellerDao seller = FactoryDao.createSellerDao();
		DepartmentDao department = FactoryDao.createDepartmentDao();
		
		System.out.println("Deseja fazer um teste? (s/n)");
		char respostaDoTeste = sc.next().charAt(0);
		
		if (respostaDoTeste == 's') {
			MenuDB.showMenu(seller, department);
			while (true) {
				System.out.print("\nDeseja continuar? (s/n)");
				char resposta = sc.next().charAt(0);
				if (resposta == 's') {
					MenuDB.showMenu(seller, department);
				} else {
					break;
				}
			}
			System.out.println("Programa encerrado.");
			sc.close();
		} else {
			System.out.println("Programa encerrado.");
			sc.close();
		}
    }

}
