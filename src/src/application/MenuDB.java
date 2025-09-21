package src.application;

import java.util.Date;
import java.util.Scanner;

import src.model.dao.DepartmentDao;
import src.model.dao.SellerDao;
import src.model.entities.Department;
import src.model.entities.Seller;

public class MenuDB {

	public static void showMenu(SellerDao sellerDao, DepartmentDao DepartmentDao) {
		Scanner sc = new Scanner(System.in);

		System.out.println("----Menu de opções----" 
				+ "\n1 - Inserir um novo vendedor" 
				+ "\n2 - Atualizar um vendedor"
				+ "\n3 - Deletar um vendedor por ID" 
				+ "\n4 - Buscar um vendedor por ID"
				+ "\n5 - Listar todos os vendedores" 
				+ "\n6 - Listar vendedores por departamento" 
				+ "\n7 - Inserir um novo departamento"
				+ "\n8 - Atualizar um departamento"
				+ "\n9 - Deletar um departamento por ID"
				+ "\n10 - Buscar um departamento por ID"
				+ "\n11 - Listar todos os departamentos"
				+ "\n0 - Sair");

		System.out.print("Escolha uma opção: ");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.println("\nOpção 1 selecionada: Inserir um novo vendedor");
			System.out.println("\nDigite os dados do vendedor:");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Data de Nascimento (YYYY-MM-DD): ");
			String birthDate = sc.next();
			Date birthDateUtil = java.sql.Date.valueOf(birthDate);
			System.out.print("Salário Base: ");
			double baseSalary = sc.nextDouble();
			System.out.print("ID do Departamento: ");
			int departmentId = sc.nextInt();
			Seller seller = new Seller(name, email, birthDateUtil, baseSalary, departmentId);

			sellerDao.insert(seller);
			break;
		case 2:
			System.out.println("\nOpção 2 selecionada: Atualizar um vendedor");
			System.out.print("Digite o ID do vendedor a ser atualizado: ");
			int idToUpdate = sc.nextInt();
			Seller sellerToUpdate = sellerDao.findById(idToUpdate);

			if (sellerToUpdate != null) {
				System.out.println("Vendedor encontrado: " + sellerToUpdate.getName());
				System.out.print(
						"Deseja mudar qual dado do vendedor? (Nome, Email, BirthDate, BaseSalary, DepartmentId): ");
				String fieldToUpdate = sc.next();

				switch (fieldToUpdate.toLowerCase()) {
				case "nome":
					System.out.print("Novo Nome: ");
					sellerToUpdate.setName(sc.next());
					break;
				case "email":
					System.out.print("Novo Email: ");
					sellerToUpdate.setEmail(sc.next());
					break;
				case "birthdate":
					System.out.print("Nova Data de Nascimento (YYYY-MM-DD): ");
					String newBirthDate = sc.next();
					sellerToUpdate.setBirthDate(java.sql.Date.valueOf(newBirthDate));
					break;
				case "basesalary":
					System.out.print("Novo Salário Base: ");
					sellerToUpdate.setBaseSalary(sc.nextDouble());
					break;
				case "departmentid":
					System.out.print("Novo ID do Departamento: ");
					int newDepartmentId = sc.nextInt();
					sellerToUpdate.setDepartmentId(new Department(newDepartmentId, null));
					break;
				default:
					System.out.println("Campo inválido. Nenhuma alteração feita.");
					return;
				}
				sellerDao.update(sellerToUpdate);
				System.out.println("Vendedor atualizado com sucesso.");
			} else {
				System.out.println("Vendedor com ID " + idToUpdate + " não encontrado.");
			}
			break;
		case 3:
			System.out.println("\nOpção 3 selecionada: Deletar um vendedor por ID");
			System.out.print("Digite o ID do vendedor a ser deletado: ");
			int idToDelete = sc.nextInt();
			sellerDao.deleteById(idToDelete);
			System.out.println("Vendedor deletado com sucesso.");
			break;
		case 4:
			System.out.println("\nOpção 4 selecionada: Buscar um vendedor por ID");
			System.out.print("Digite o ID do vendedor a ser buscado: ");
			int idToFind = sc.nextInt();
			Seller foundSeller = sellerDao.findById(idToFind);
			if (foundSeller != null) {
				System.out.println("Vendedor encontrado: " + foundSeller);
			} else {
				System.out.println("Vendedor com ID " + idToFind + " não encontrado.");
			}
			break;
		case 5:
			System.out.println("\nOpção 5 selecionada: Listar todos os vendedores");
			for (Seller s : sellerDao.findAll()) {
				System.out.println(s);
			}
			break;
		case 6:
			System.out.println("\nOpção 6 selecionada: Listar vendedores por departamento");
			System.out.print("Digite o ID do departamento: ");
			int deptId = sc.nextInt();
			Department dep = new Department(deptId, null);
			for (Seller s : sellerDao.findByDepartment(dep)) {
				System.out.println(s);
			}
			break;
		case 7:
			System.out.println("\nOpção 7 selecionada: Inserir um novo departamento");
			System.out.println("Digite os dados do departamento:");
			System.out.print("Nome: ");
			sc.nextLine();
			String deptName = sc.nextLine();
			Department newDep = new Department(null, deptName);
			
			DepartmentDao.insert(newDep);
			
			break;
		case 8:
			System.out.println("\nOpção 8 selecionada: Atualizar um departamento");
			System.out.print("Digite o ID do departamento a ser atualizado: ");
			int deptIdToUpdate = sc.nextInt();
			Department depToUpdate = DepartmentDao.findById(deptIdToUpdate);

			if (depToUpdate != null) {
				System.out.println("Departamento encontrado: " + depToUpdate.getName());
				System.out.print("Novo Nome: ");
				sc.nextLine();
				depToUpdate.setName(sc.nextLine());
				
				DepartmentDao.update(depToUpdate);
				System.out.println("Departamento atualizado com sucesso.");
			} else {
				System.out.println("Departamento com ID " + deptIdToUpdate + " não encontrado.");
			}
			break;
		case 9:
			System.out.println("\nOpção 9 selecionada: Deletar um departamento por ID");
			System.out.print("Digite o ID do departamento a ser deletado: ");
			int deptIdToDelete = sc.nextInt();
			DepartmentDao.deleteById(deptIdToDelete);
			System.out.println("Departamento deletado com sucesso.");
			break;
		case 10:
			System.out.println("\nOpção 10 selecionada: Buscar um departamento por ID");
			System.out.print("Digite o ID do departamento a ser buscado: ");
			int deptIdToFind = sc.nextInt();
			Department foundDep = DepartmentDao.findById(deptIdToFind);
			if (foundDep != null) {
				System.out.println("Departamento encontrado: " + foundDep);
			} else {
				System.out.println("Departamento com ID " + deptIdToFind + " não encontrado.");
			}
			break;
		case 11:
			System.out.println("\nOpção 11 selecionada: Listar todos os departamentos");
			for (Department d : DepartmentDao.findAll()) {
				System.out.println(d);
			}
			break;
		case 0:
			System.out.println("Saindo do programa.");
		default:
			System.out.println("Opção inválida. Tente novamente.");
			break;
		}
	}
}
