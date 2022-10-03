package com.machoapp.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.machoapp.model.Category;
import com.machoapp.exceptions.IdNotFoundException;
import com.machoapp.exceptions.NotUniqueException;
import com.machoapp.exceptions.ProductNotFoundException;
import com.machoapp.exceptions.UserNotFoundException;
import com.machoapp.model.Brand;
import com.machoapp.model.Dress;
import com.machoapp.model.Material;
import com.machoapp.model.Size;
import com.machoapp.model.User;
import com.machoapp.service.DressServiceImpl;
import com.machoapp.service.IDressService;
import com.machoapp.service.IUserService;
import com.machoapp.service.UserServiceImpl;

public class DressMain {

	public static void main(String[] args) throws SQLException {
		IDressService dressService=new DressServiceImpl();
		Scanner sc=new Scanner(System.in);
		User user=new User();

		boolean outFlag=true;
		while(outFlag) {
			System.out.println("Select an option \n1.Admin \n2.User \n3.Exit");

			int option=sc.nextInt();
			sc.nextLine();

			if(option==1) {
				boolean flagReg=true;
				do {
					IUserService userService=new UserServiceImpl();
					user=null;
					System.out.println("Enter UserName:");
					String userName=sc.nextLine();
					System.out.println("Enter password:");
					String password=sc.nextLine();
					try {
						user=userService.login(userName, password);
					} catch (UserNotFoundException e) {
						e.printStackTrace();
					}
					System.out.println("To change password press 1");
					int pass=sc.nextInt();
					sc.nextLine();
					if(pass==1) {
						password=sc.nextLine();
						int upd=userService.changePassword(userName, password);
						if(upd==1) {
							System.out.println("Updated successfully");
						}
					}
					if(user==null) {
						System.out.println("Invalid credentials");
						break;
					}
					else {
						flagReg=false;
					}
				}while(flagReg);
				System.out.println("Welcome Admin...");
				boolean flag=true;

				while(flag) {
					System.out.println("Select an option \n1.Add a Dress \n2.Update the Dress \n3.Delete a Dress \n4.Find by Id \n5.Logout");
					option=sc.nextInt();
					sc.nextLine();

					switch(option) {
					case 1:
						Dress dress=new Dress();
						System.out.println("Enter details one  by one as follows: ");
						System.out.println("ProductName: ");
						dress.setProductName(sc.nextLine());

						String gender=null;
						if(option==1) {
							gender="Male";
						}else if(option==2) {
							gender="Female";
						}else {
							gender="Unisex";
						}
						dress.setGender(gender);

						System.out.println("Select a category: 	\n1.SHIRT \n2.PANT \n3.TSHIRTS \n4.HOODIES \n5.LOWERS \n6.CHUDI \n7.SAREE \n8.LEGIN");
						option=sc.nextInt();
						sc.nextLine();		
						dress.setCategory(Category.values()[option-1].category);					

						System.out.println("Select the material: \n1.COTTON \n2.DENIM \n3.LINEN");
						option=sc.nextInt();
						sc.nextLine();
						dress.setMaterial(Material.values()[option-1].material);

						System.out.println("Select a Brand:	\n1.LOUYPHILLIS \n2.MAX \n3.ZIVA \n4.PAULWALKER \n5.JDY \n6.USPOLO \n7.COSCO \n8.CHIVAS \n9.LEECOOPER");
						option=sc.nextInt();
						sc.nextLine();
						dress.setBrand(Brand.values()[option-1].brand);

						System.out.println("Enter the size : 1.XS  \n2.S  \n3.M  \n4.L  \n5.XL  \n6.XXL  \n7.XXXL  \n8.FREESIZE");						
						option=sc.nextInt();
						sc.nextLine();	
						dress.setSize(Size.values()[option-1].size);

						System.out.println("Color:");
						dress.setColor(sc.nextLine());

						System.out.println("Price:");
						dress.setPrice(sc.nextDouble());
						sc.nextLine();

						System.out.println("Rating(Out of 5):");
						dress.setRating(sc.nextDouble());
						sc.nextLine();

						if(dressService.addDress(dress)!=0) {
							System.out.println("Added Successfully....");
						}
						break;

					case 2:
						System.out.println("Enter the product Id and price to be updated: ");
						int id=sc.nextInt();
						sc.nextLine();
						System.out.println("Price to be updated:");
						double price=sc.nextDouble();
						sc.nextLine();
						try {
							if(dressService.updateDress(id, price)!=0) {
								System.out.println("Updated Successfully");
							}
						} catch (IdNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						break;

					case 3:
						System.out.println("Enter product Id to be deleted: ");
						int val=0;
						try {
							val = dressService.deleteDress(sc.nextInt());
						} catch (IdNotFoundException e1) {
							e1.printStackTrace();
						}
						sc.nextLine();
						if(val!=0) {
							System.out.println("Deleted Successfully");
						}					
						break;

					case 4:
						System.out.println("Enter the product id: ");
						try {
							System.out.println(dressService.findById(sc.nextInt()));
						} catch (IdNotFoundException e) {
							e.printStackTrace();
						}
						sc.nextLine();
						break;

					case 5:
						flag=false;
						break;

					default:
						System.out.println("Invalid option");
					}
				}
			}
			else if(option==2){
				boolean flagReg=true;
				do {
					System.out.println("1.Register \n2.Login");
					IUserService userService=new UserServiceImpl();
					int action=sc.nextInt();
					sc.nextLine();
					if(action==1) {
						user=new User();
						System.out.println("Enter UserName:");
						user.setUsername(sc.nextLine());
						System.out.println("Enter the name:");
						user.setName(sc.nextLine());
						System.out.println("Enter your Mobile number:");
						user.setMobile(sc.nextLong());
						sc.nextLine();
						System.out.println("Enter the location: ");
						user.setLocation(sc.nextLine());
						System.out.println("Enter the password:");
						user.setPassword(sc.nextLine());

						try {
							userService.register(user);
						} catch (NotUniqueException e) {
							e.printStackTrace();
						}
					}
					else if(action==2){
						user=null;
						System.out.println("Enter UserName:");
						String userName=sc.nextLine();
						System.out.println("Enter password:");
						String password=sc.nextLine();
						try {
							user=userService.login(userName, password);
						} catch (UserNotFoundException e) {
							e.printStackTrace();
						}
						System.out.println("To change password press 1");
						int pass=sc.nextInt();
						sc.nextLine();
						
						if(pass==1) {
							password=sc.nextLine();
							userService.changePassword(userName, password);
						}
					}
					if(user==null) {
						System.out.println("Invalid credentials");
					}
					else {
						flagReg=false;
					}
				}while(flagReg);
				
				System.out.println("Welcome Buddy...");
				boolean flag=true;

				while(flag) {
					System.out.println("Select an option \n1.Find by Id \n2.Filter by Gender \n3.Filter by Gender & Category \n4.Filter by Gender and Size \n5.Filter by Color and Category \n6.Filter by Material and Category");
					System.out.println("7.Filter by Brand and Rating \n8.Filter by Brand and Size \n9.Filter by Category and Rating \n10.Filter by Category and Price \n11.Logout");
					option=sc.nextInt();
					sc.nextLine();

					switch(option) {
					case 1:
						System.out.println("Enter the product id: ");
						try {
							Dress dress=dressService.findById(sc.nextInt());
							sc.nextLine();	
							System.out.println(dress);
						} catch (IdNotFoundException e) {
							e.printStackTrace();
						}
						break;

					case 2:
						System.out.println("Select an option \n1.Male \n2.Female \n3.Unisex");
						option=sc.nextInt();
						sc.nextLine();

						String gender=null;
						if(option==1) {
							gender="Male";
						}else if(option==2) {
							gender="Female";
						}else {
							gender="Unisex";
						}

						try {
							dressService.getByGender(gender).forEach(System.out::println);
						} catch (ProductNotFoundException e) {
							e.printStackTrace();
						}
						break;

					case 3:
						String category=null;
						System.out.println("Select an option \n1.Male \n2.Female \n3.Unisex");
						option=sc.nextInt();
						sc.nextLine();

						gender=null;
						if(option==1) {
							gender="Male";
						}else if(option==2) {
							gender="Female";
						}else {
							gender="Unisex";
						}

						if(gender.equals("Male")) {
							System.out.println("Select the category: \n1.SHIRT \n2.PANT \n3.TSHIRTS \n4.HOODIES \n5.LOWERS ");
							option=sc.nextInt();
							sc.nextLine();
							category=Category.values()[option-1].category;
						}else if(gender.equals("Female")) {
							System.out.println("Select the ctegory: \n1.CHUDI \n2.SAREE \n3.LEGIN");
							option=sc.nextInt();
							sc.nextLine();
							category=Category.values()[option+5-1].category;						
						}else {
							System.out.println("Select the category: \n1.TSHIRTS \n2.HOODIES \n3.LOWERS");
							option=sc.nextInt();
							sc.nextLine();
							category=Category.values()[option+2-1].category;						
						}

						if(category!=null)
							try {
								dressService.getByGenderAndCategory(gender, category).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						break;

					case 4: //Filter by Gender and Size
						System.out.println("Select an option \n1.Male \n2.Female \n3.Unisex");
						option=sc.nextInt();
						sc.nextLine();

						gender=null;
						if(option==1) {
							gender="Male";
						}else if(option==2) {
							gender="Female";
						}else {
							gender="Unisex";
						}

						String size=null;
						System.out.println("Enter the size : \n1.XS  \n2.S  \n3.M  \n4.L  \n5.XL  \n6.XXL  \n7.XXXL  \n8.FREESIZE");						
						option=sc.nextInt();
						sc.nextLine();
						size=Size.values()[option-1].size;

						if(size!=null)
							try {
								System.out.println("uih");
								dressService.getByGenderAndSize(gender, size).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						break;
					case 5: //Filter by Color and Category 
						System.out.println("Enter the color:");
						String color=sc.nextLine();

						category=null;
						System.out.println("Select a category: 	\n1.SHIRT \n2.PANT \n3.TSHIRTS \n4.HOODIES \n5.LOWERS \n6.CHUDI \n7.SAREE \n8.LEGIN");
						option=sc.nextInt();
						sc.nextLine();		
						category =Category.values()[option-1].category;
						System.out.println("Selected:"+category);
						if(category!=null)
							try {
								dressService.getByColorAndCategory(color, category).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	

						break;
					case 6: //Filter by Material and Category
						String material=null;
						System.out.println("Select the material: \n1.COTTON \n2.DENIM \n3.LINEN");
						option=sc.nextInt();
						sc.nextLine();
						material=Material.values()[option-1].material;

						category=null;
						System.out.println("Select a category: 	\n1.SHIRT \n2.PANT \n3.TSHIRTS \n4.HOODIES \n5.LOWERS \n6.CHUDI \n7.SAREE \n8.LEGIN");
						option=sc.nextInt();
						sc.nextLine();		
						category =Category.values()[option-1].category;

						if(category!=null&&material!=null)
							try {
								dressService.getByMaterialAndCategory(material, category).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}						

						break;
					case 7: //Filter by Brand and Rating
						String brand=null;
						System.out.println("Select a Brand:	\n1.LOUYPHILLIS \n2.MAX \n3.ZIVA \n4.PAULWALKER \n5.JDY \n6.USPOLO \n7.COSCO \n8.CHIVAS \n9.LEECOOPER");
						option=sc.nextInt();
						sc.nextLine();
						brand=Brand.values()[option-1].brand;

						System.out.println("Enter the expected Rating");
						double rating=sc.nextDouble();
						sc.nextLine();

						if(brand!=null)
							try {
								dressService.getByBrandAndRating(brand, rating).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	

						break;
					case 8: //Filter by Brand and Size
						brand=null;
						System.out.println("Select a Brand:	\n1.LOUYPHILLIS \n2.MAX \n3.ZIVA \n4.PAULWALKER \n5.JDY \n6.USPOLO \n7.COSCO \n8.CHIVAS \n9.LEECOOPER");
						option=sc.nextInt();
						sc.nextLine();
						brand=Brand.values()[option-1].brand;

						size=null;
						System.out.println("Enter the size : 1.XS  \n2.S  \n3.M  \n4.L  \n5.XL  \n6.XXL  \n7.XXXL  \n8.FREESIZE");						
						option=sc.nextInt();
						sc.nextLine();
						size=Size.values()[option-1].size;

						if(brand!=null&&size!=null)
							try {
								dressService.getByBrandAndSize(brand, size).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	

						break;
					case 9: //Filter by Category and Rating 
						category=null;
						System.out.println("Select a category: 	\n1.SHIRT \n2.PANT \n3.TSHIRTS \n4.HOODIES \n5.LOWERS \n6.CHUDI \n7.SAREE \n8.LEGIN");
						option=sc.nextInt();
						sc.nextLine();		
						category =Category.values()[option-1].category;

						System.out.println("Enter the expected Rating");
						rating=sc.nextDouble();
						sc.nextLine();

						if(category!=null)
							try {
								dressService.getByCategoryAndRating(category, rating).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	

						break;
					case 10: //Filter by Category and Price
						category=null;
						System.out.println("Select a category: 	\n1.SHIRT \n2.PANT \n3.TSHIRTS \n4.HOODIES \n5.LOWERS \n6.CHUDI \n7.SAREE \n8.LEGIN");
						option=sc.nextInt();
						sc.nextLine();		
						category =Category.values()[option-1].category;

						System.out.println("Enter the price:");
						int price=sc.nextInt();

						if(category!=null)
							try {
								dressService.getByCategoryAndPrice(category, price).forEach(System.out::println);
							} catch (ProductNotFoundException e) {
								e.printStackTrace();
							}	

						break;
					case 11:
						flag=false;
						break;
					default:
						System.out.println("Invalid option");
					}
				}
			}
			else {
				outFlag=false;
			}
		}
		sc.close();
	}
}
