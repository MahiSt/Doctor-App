package com.machoapp.service;

import java.util.List;

import com.machoapp.exceptions.IdNotFoundException;
import com.machoapp.exceptions.ProductNotFoundException;
import com.machoapp.model.Dress;

public interface IDressService {

	int addDress(Dress dress);
	int updateDress(int productId,double price) throws IdNotFoundException;
	int deleteDress(int productId) throws IdNotFoundException;
	Dress findById(int productId) throws IdNotFoundException;
	
	List<Dress> getByGender(String gender) throws ProductNotFoundException;
	List<Dress> getByGenderAndCategory(String gender,String category) throws ProductNotFoundException;	
	List<Dress> getByGenderAndSize(String size, String gender) throws ProductNotFoundException;
	List<Dress> getByColorAndCategory(String color,String category) throws ProductNotFoundException;	
	List<Dress> getByMaterialAndCategory(String material,String category) throws ProductNotFoundException;
	List<Dress> getByBrandAndRating(String brand,double rating)throws ProductNotFoundException;
	List<Dress> getByBrandAndSize(String brand,String size)throws ProductNotFoundException;
	List<Dress> getByCategoryAndRating(String category,double rating) throws ProductNotFoundException;
	List<Dress> getByCategoryAndPrice(String category,double price) throws ProductNotFoundException;

}
