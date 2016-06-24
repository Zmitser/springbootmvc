package by.zmitserkoskinen.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private Integer id;
    private String description;
    private String imageUrl;
    private BigDecimal price;

}

