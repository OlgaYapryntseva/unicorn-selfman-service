package com.selfman.business.requests.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class ProviderBusinessRequestsDto {
       String id;
       String customerEmail;
       String productDescription;
       List<String> files;
       String status;
       LocalDateTime dateTime;
}
