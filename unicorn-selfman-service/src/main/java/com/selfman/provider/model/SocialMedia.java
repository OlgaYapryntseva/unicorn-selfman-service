package com.selfman.provider.model;

import java.util.Random;

import org.springframework.data.annotation.Id;

import lombok.Getter;

@Getter
public class SocialMedia {
    @Id
    Integer socialMediaId = (int) new Random().nextInt(200000);
	String name;
	String link;
}
