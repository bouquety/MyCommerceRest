package com.mycommerce.project;

import com.mycommerce.project.dao.DaoFactory;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.model.Product;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao dao = DaoFactory.getProductDao();
        dao.addProduct(new Product("Bouteille d'eau","Bouteille 2L, eau minérale naturelle",0.65F));
        dao.addProduct(new Product("JeuxVideo","Elden Ring",50F));
        dao.addProduct(new Product("Football","Ballon",25F));
        dao.addProduct(new Product("Ecran","MSI",250F));

    }
}
