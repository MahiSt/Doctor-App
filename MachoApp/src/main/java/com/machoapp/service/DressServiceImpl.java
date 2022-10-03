package com.machoapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.machoapp.dao.DressDaoImpl;
import com.machoapp.dao.IDressDao;
import com.machoapp.exceptions.*;
import com.machoapp.model.Dress;

public class DressServiceImpl implements IDressService {
	IDressDao dressDao=new DressDaoImpl();

	@Override
	public int addDress(Dress dress){
		return dressDao.addDress(dress);
	}

	@Override
	public int updateDress(int productId, double price) throws IdNotFoundException{
		int result=dressDao.updateDress(productId, price);
		if(result==0)
			throw new IdNotFoundException();
		return result;
	}

	@Override
	public int deleteDress(int productId) throws IdNotFoundException{
		int result=dressDao.deleteDress(productId);
		if(result==0)
			throw new IdNotFoundException();
		return result;
	}

	@Override
	public Dress findById(int productId) throws IdNotFoundException{
		Dress dress=dressDao.findById(productId);
		if(dress==null) {
			throw new IdNotFoundException();			
		}
		return dress;
	}

	@Override
	public List<Dress> getByGender(String gender) throws ProductNotFoundException{
		List<Dress> dresses= dressDao.findByGender(gender)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());

		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
	}

	@Override
	public List<Dress> getByGenderAndCategory(String gender, String category) throws ProductNotFoundException{
		List<Dress> dresses= dressDao.findByGenderAndCategory(gender,category)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;	
	}

	@Override
	public List<Dress> getByGenderAndSize(String gender,String size) throws ProductNotFoundException {
		List<Dress> dresses=dressDao.findByGenderAndSize(gender,size)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
	}

	@Override
	public List<Dress> getByColorAndCategory(String color, String category) throws ProductNotFoundException {
		List<Dress> dresses=		dressDao.findByColorAndCategory(color,category)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
}

	@Override
	public List<Dress> getByMaterialAndCategory(String material, String category) throws ProductNotFoundException {
		List<Dress> dresses= dressDao.findByMaterialAndCategory(material,category)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
	}

	@Override
	public List<Dress> getByBrandAndRating(String brand, double rating) throws ProductNotFoundException {
		List<Dress> dresses= dressDao.findByBrandAndRating(brand,rating)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
	}

	@Override
	public List<Dress> getByBrandAndSize(String brand, String size) throws ProductNotFoundException {
		List<Dress> dresses= dressDao.findByBrandAndSize(brand,size)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
	}

	@Override
	public List<Dress> getByCategoryAndRating(String category, double rating) throws ProductNotFoundException {
		List<Dress> dresses= dressDao.findByCategoryAndRating(category,rating)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
	}

	@Override
	public List<Dress> getByCategoryAndPrice(String category, double price) throws ProductNotFoundException {
		List<Dress> dresses= dressDao.findByCategoryAndPrice(category,price)
				.stream()
				.sorted((d1,d2)->{
					return d1.getProductName().compareTo(d1.getProductName());
				})
				.collect(Collectors.toList());
		if(dresses.isEmpty()) {
			throw new ProductNotFoundException("Oops!..Currently its out of stock...");
		}
		return dresses;
	}


}
