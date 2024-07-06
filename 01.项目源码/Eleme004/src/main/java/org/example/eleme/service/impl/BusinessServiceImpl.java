package org.example.eleme.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.eleme.mapper.BusinessMapper;
import org.example.eleme.model.Business;
import org.example.eleme.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("businessService")
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Override
    public List<Business> getAllBusinesses(String sortField, String sortOrder) {
        // 简单实现排序逻辑
        List<Business> businesses = baseMapper.getAll();
        Comparator<Business> comparator;

        switch (sortField) {
            case "sales":
                comparator = Comparator.comparing(Business::getSales);
                break;
            case "distance":
                comparator = Comparator.comparing(Business::getDistance);
                break;
            case "avgprice":
                comparator = Comparator.comparing(Business::getAvgprice);
                break;
            case "rating":
            default:
                comparator = Comparator.comparing(Business::getRating);
                break;
        }

        if ("desc".equalsIgnoreCase(sortOrder)) {
            comparator = comparator.reversed();
        }

        return businesses.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public boolean deleteBusinessById(Long id) {
        return this.removeById(id);
    }
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public Business findById(Long businessid) {
        return businessMapper.findById(businessid);
    }
}
