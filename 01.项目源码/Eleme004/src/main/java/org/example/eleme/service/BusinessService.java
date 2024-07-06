package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.Business;
import java.util.List;


public interface BusinessService extends IService<Business> {

    List<Business> getAllBusinesses(String sortField, String sortOrder);
    boolean deleteBusinessById(Long id);
    Business findById(Long businessid);
}
