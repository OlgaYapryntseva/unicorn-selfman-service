package com.selfman.provider.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"link"})
public class SocialMedia {
//	@Id
//	Integer socialMediaId = (int) new Random().nextInt(200000);
	String name;
	String link;
}
