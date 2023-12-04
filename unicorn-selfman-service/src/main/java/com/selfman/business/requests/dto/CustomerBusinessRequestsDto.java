package com.selfman.business.requests.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class CustomerBusinessRequestsDto {
    String id;
    String providerEmail;
    String productDescription;
    List<String> files;
    String status;
    LocalDateTime dateTime;
}
