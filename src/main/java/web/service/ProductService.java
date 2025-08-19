package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.ProductDao;
import web.model.dto.ProductDto;

import java.sql.PreparedStatement;

@Service
public class ProductService {

    @Autowired private ProductDao productDao;

    // 1-1. 제품 등록
    public int createProduct( ProductDto productDto ){
        int result = productDao.createProduct( productDto );
        return result;
    }
    // 1-2. 제품 이미지 등록
    public boolean createProductImage( int pno , String fileName ){
        boolean result = productDao.createProductImage( pno, fileName);
        return result;
    }// func end

    // 2. 전체 제품 조회

    // 3. 제품 상세 조회


}// class end
