package application;


import java.util.Date;
import java.util.List;
import java.util.Locale;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===Teste 1: Seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("=== Test 2: seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller se: list) {
			System.out.println(se);
		}
		
		System.out.println("===Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller se : list) {
			System.out.println(se);
		}
		
		/*System.out.println("===Test 4: seller Insert ===");
		Seller seller3 = new Seller("Antorio", "antonio@gmail.com", new Date(), 5000.00, dep);
		sellerDao.insert(seller3);
		System.out.println("Inserted! New id= " + seller3.getId());*/
		
		System.out.println("===Test 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("João da Silva");
		sellerDao.update(seller);
		System.out.println("Update completed!");
	}

}
