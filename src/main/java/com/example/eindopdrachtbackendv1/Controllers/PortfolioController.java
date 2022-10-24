package com.example.eindopdrachtbackendv1.Controllers;

import com.example.eindopdrachtbackendv1.Services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;


}
