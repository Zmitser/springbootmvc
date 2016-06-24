package by.zmitserkoskinen.services;

import by.zmitserkoskinen.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();

    Product productsById(Integer id);

    Product saveOrUpdateProduct(Product product);
}
