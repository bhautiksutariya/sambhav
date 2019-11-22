package com.sambhav.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sambhav.model.RequestProduct;
import com.sambhav.model.RequestProductDTO;
import com.sambhav.repository.RequestProductRepository;

@Service
public class RequestProductDAO {

	@Autowired
	private RequestProductRepository requestProductRepository;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ProductDAO productDao;
	
	public RequestProduct requestProduct(RequestProductDTO request)
	{
		RequestProduct r=new RequestProduct();
		r.setDatetime(new Date());
		r.setUserid(userDao.getUserByEmail(CurrentUser.getCurrentUserEmail()));
		r.setProductid(productDao.getProduct(request.getProductid()));
		return requestProductRepository.save(r);
	}
	
	public List<RequestProduct> getRequestProduct()
	{
		return requestProductRepository.findAll();
	}
	
	public List<RequestProduct> getRequestProduct(int productId)
	{
		return requestProductRepository.findByProductid(productDao.getProduct(productId));
	}
	
}
