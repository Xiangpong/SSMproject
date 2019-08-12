package com.pong.service.impl;

import EasyUIPojo.EasyGrid;
import EasyUIPojo.ResponseJsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pong.mapper.ProductMapper;
import com.pong.pojo.Product;
import com.pong.pojo.ProductExample;
import com.pong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseJsonResult saveProduct(Product product) {

        product.setStatus(1);
        productMapper.insert(product);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);


        return responseJsonResult;
    }

    @Override
    public EasyGrid listProduct(int pages, int rows) {
        ProductExample  productExample = new ProductExample();
        PageHelper.startPage(pages,rows);

        List<Product> productsList = productMapper.selectByExample(productExample);

        PageInfo<Product> pageInfo = new PageInfo<>(productsList);

        EasyGrid easyGrid = new EasyGrid();
        easyGrid.setTotal((int) pageInfo.getTotal());
        easyGrid.setRows(productsList);

        return easyGrid;

    }

    @Override
    public ResponseJsonResult editorProduct(Product product) {
        productMapper.updateByPrimaryKey(product);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);

        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult removeProduct(Short id) {
        productMapper.deleteByPrimaryKey((int)id);
        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);

        return responseJsonResult;
    }


}
