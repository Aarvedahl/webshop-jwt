package org.techforumist.jwt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.techforumist.jwt.dto.Purchasedto;
import org.techforumist.jwt.jpa.AppUser;
import org.techforumist.jwt.jpa.Article;
import org.techforumist.jwt.jpa.Purchase;
import org.techforumist.jwt.jpa.Purchase_article;
import org.techforumist.jwt.repository.OrderRepository;
import org.techforumist.jwt.repository.Purchase_articleRepository;
import org.techforumist.jwt.repository.UserRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    Purchase_articleRepository purchaseRepository;

    @Autowired
    UserRepository userRepository;

    List<Purchase> orders;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Purchase> getOrders() {
        orders = orderRepository.findAll();
        return orders;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public void makePurchase(@RequestBody List<Article> articles) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
       /*AppUser users = userRepository.findOneByUsername(auth.getName());
        Purchase purchase = new Purchase(new Date(), false, new AppUser(users.getUserid()));
       orderRepository.save(purchase);
       for(Article article: articles) {
           Purchase_article purchase_article = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(article.getArticleid()));
           purchaseRepository.save(purchase_article);
       } */
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping
    public void editPurchase(@RequestBody Purchasedto purchasedto) {
        Purchase purchase = new Purchase(purchasedto.getOrderid(), new AppUser(purchasedto.getUserid()), purchasedto.getOrderdate(), purchasedto.isCanceled());
        orderRepository.save(purchase);
    }


}
