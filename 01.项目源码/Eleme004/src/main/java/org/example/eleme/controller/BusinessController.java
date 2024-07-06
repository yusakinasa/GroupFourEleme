package org.example.eleme.controller;

import org.example.eleme.model.Business;
import org.example.eleme.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/all")
    public Map<String, Object> getAll(@RequestParam(defaultValue = "rating") String sortField,
                                      @RequestParam(defaultValue = "desc") String sortOrder) {
        Map<String, Object> mapjson = new HashMap<>();
        mapjson.put("data", businessService.getAllBusinesses(sortField, sortOrder));
        return mapjson;
    }

    @PostMapping
    public Map<String, Object> addBusiness(@RequestBody Business business) {
        businessService.save(business);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", business);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteBusiness(@PathVariable("id") Long businessId) {
        Map<String, Object> response = new HashMap<>();
        boolean isDeleted = businessService.deleteBusinessById(businessId);
        response.put("success", isDeleted);
        response.put("message", isDeleted ? "Business deleted successfully" : "Business deletion failed");
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable("id") Long id) {
        Business business = businessService.findById(id);
        if (business != null) {
            return ResponseEntity.ok(business);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}



