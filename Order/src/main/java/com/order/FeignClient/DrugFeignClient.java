package com.order.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.pharmacy.model.Drug;

@FeignClient(name = "Drug", url = "http://localhost:8080/drug")
public interface DrugFeignClient {

    @GetMapping("/findById/{drugId}")
    ResponseEntity<Drug> getById(@PathVariable("drugId") long drugId);

    @PutMapping("/updateStock/{drugId}")
    ResponseEntity<Drug> updateStock(@PathVariable("drugId") long drugId,@RequestBody Drug drug);
}