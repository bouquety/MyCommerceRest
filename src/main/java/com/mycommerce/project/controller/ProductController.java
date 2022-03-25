package com.mycommerce.project.controller;

import com.mycommerce.project.controller.model.CreateProduct;
import com.mycommerce.project.controller.model.ProductResponse;
import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;
import com.mycommerce.project.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/list-product")
public class ProductController {

    @Inject
    ProductService productService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateProduct createProduct) {
        Product product = new Product(createProduct.getName(), createProduct.getContent(), createProduct.getPrice());
        ProductDao productDao = DaoFactory.getProductDao();
        productDao.addProduct(product);
        return Response.status(201).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<ProductResponse> productResponses = productService.fetchAll();
        return Response.ok(productResponses).build();
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Product product) {
        ProductDao productDao = DaoFactory.getProductDao();
        productDao.removeProduct(product.getId());
        return Response.status(201).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateMovie(@PathParam("id") Long id,
                                @FormParam("name") String name,
                                @FormParam("content") String content,
                                @FormParam("price") float price) {
        Product product = new Product(name, content, price);
        boolean isUpdated = DaoFactory.getProductDao().updateProduct(product);

        if (isUpdated) {
            return Response.noContent().build();
        } else {
            return Response.notModified().build();
        }


    }

}
