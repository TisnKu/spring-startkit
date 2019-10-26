package com.txku.springstartkit.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "${some_service.name}", url = "${some_service.url}")
public interface SomeFeignClient {
    @GetMapping(value = "/api/users")
    List<Object> getAllUsers();
}
