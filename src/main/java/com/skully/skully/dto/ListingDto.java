package com.skully.skully.dto;

import java.math.BigDecimal;
import java.util.List;

public class ListingDto {
    public Long id;
    public String title;
    public String description;
    public BigDecimal price;
    public List<String> images;
    public String location;
    public String category;
    public Long sellerId;
}
