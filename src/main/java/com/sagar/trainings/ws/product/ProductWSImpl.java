package com.sagar.trainings.ws.product;

import java.io.File;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sagar.trainings.ws.product.dao.ProductDAO;
import com.sagar.trainings.ws.product.dto.Product;

public class ProductWSImpl implements ProductWS {

	private ProductDAO dao;
	
	public ProductDAO getDao() {
		return dao;
	}

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public Response add(Product product) {
		com.sagar.trainings.ws.product.entity.Product productEntity = mapWsToDao(product);
		dao.create(productEntity);
		return Response.ok().build();
	}

	private com.sagar.trainings.ws.product.entity.Product mapWsToDao(Product product) {
		com.sagar.trainings.ws.product.entity.Product productEntity = new com.sagar.trainings.ws.product.entity.Product();
		productEntity.setId(product.getId());
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setPrice(product.getPrice());
		return productEntity;
	}

	@Override
	public Response update(Product product) {
		dao.update(product.getId(), product.getPrice());
		return Response.ok().build();
	}

	@Override
	public Response delete(int id) {
		dao.delete(id);
		return Response.ok().build();
	}

	@Override
	public Product find(int id) {
		com.sagar.trainings.ws.product.entity.Product productEntity = dao.find(id);
		Product product = mapDaoToWs(productEntity);
		return product;
	}

	private Product mapDaoToWs(com.sagar.trainings.ws.product.entity.Product productEntity) {
		Product product = new Product();
		product.setId(productEntity.getId());
		product.setName(productEntity.getName());
		product.setDescription(productEntity.getDescription());
		product.setPrice(productEntity.getPrice());
		return product;
	}

	@Override
	public Response getFile() {
	        File file = new File(System.getProperty("user.home")+"/Desktop/tmp.txt");
	        ResponseBuilder response = Response.ok((Object) file);
	        response.header("Content-Disposition", "attachment;filename=test.txt");
	        return response.build();
	}

}
