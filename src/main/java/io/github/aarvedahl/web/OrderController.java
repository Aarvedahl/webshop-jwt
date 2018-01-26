package io.github.aarvedahl.web;

import io.github.aarvedahl.jpa.Article;
import io.github.aarvedahl.repository.OrderRepository;
import io.github.aarvedahl.repository.Purchase_articleRepository;
import io.github.aarvedahl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import io.github.aarvedahl.dto.Purchasedto;
import io.github.aarvedahl.jpa.AppUser;
import io.github.aarvedahl.jpa.Purchase;
import io.github.aarvedahl.jpa.Purchase_article;

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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<Purchase> getOrders() {
        orders = orderRepository.findAll();
        return orders;
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping
    public void makePurchase(@RequestBody List<Article> articles) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser users = userRepository.findOneByUsername(auth.getName());
        Purchase purchase = new Purchase(new Date(), false, new AppUser(users.getUserid()));
        orderRepository.save(purchase);
        for (Article article : articles) {
            Purchase_article purchase_article = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(article.getArticleid()));
            purchaseRepository.save(purchase_article);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping
    public void editPurchase(@RequestBody Purchasedto purchasedto) {
        Purchase purchase = new Purchase(purchasedto.getOrderid(), new AppUser(purchasedto.getUserid()), purchasedto.getOrderdate(), purchasedto.isCanceled());
        orderRepository.save(purchase);
    }


}
