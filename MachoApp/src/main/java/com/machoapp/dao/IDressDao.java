package com.machoapp.dao;

import java.util.List;

import com.machoapp.model.Dress;

public interface IDressDao {

	int addDress(Dress dress);
	int updateDress(int productId,double price);
	int deleteDress(int productId);
	Dress findById(int productId);
	
	List<Dress> findByGender(String gender);
	List<Dress> findByGenderAndCategory(String gender,String category);	
	List<Dress> findByGenderAndSize(String gender, String size);
	List<Dress> findByColorAndCategory(String color,String category);	
	List<Dress> findByMaterialAndCategory(String material,String category);
	List<Dress> findByBrandAndRating(String brand,double rating);
	List<Dress> findByBrandAndSize(String brand,String size);
	List<Dress> findByCategoryAndRating(String category,double rating);
	List<Dress> findByCategoryAndPrice(String category,double price);

	
	
}
