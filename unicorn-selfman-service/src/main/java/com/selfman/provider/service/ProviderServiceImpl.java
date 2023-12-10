package com.selfman.provider.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.selfman.provider.dao.ProviderRepository;
import com.selfman.provider.dto.ProviderChangePasswordDto;
import com.selfman.provider.dto.ProviderCreateDto;
import com.selfman.provider.dto.ProviderDto;
import com.selfman.provider.dto.ProviderRegisterDto;
import com.selfman.provider.dto.ProviderRemoveDto;
import com.selfman.provider.dto.ProviderUpdateDto;
import com.selfman.provider.exceptions.ProviderExistsExeption;
import com.selfman.provider.exceptions.ProviderNotFoundException;
import com.selfman.provider.model.Provider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

	final ProviderRepository providerRepository;
	final ModelMapper modelMapper;
	final PasswordEncoder passwordEncoder;

	@Override
	public ProviderCreateDto createProvider(ProviderRegisterDto providerRegisterDto) {
		if (providerRepository.findByEmail(providerRegisterDto.getEmail()).isPresent()) {
			throw new ProviderExistsExeption();
		}
		Provider provider = modelMapper.map(providerRegisterDto, Provider.class);
		String password = passwordEncoder.encode(providerRegisterDto.getPassword());
		provider.setPassword(password);
		providerRepository.save(provider);
		return modelMapper.map(provider, ProviderCreateDto.class);
	}

	@Override

	public ProviderUpdateDto updateProvider(String email, ProviderUpdateDto providerUpdateDto) {
		Provider provider = providerRepository.findByEmail(email).orElseThrow(ProviderNotFoundException::new);
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.map(providerUpdateDto, provider);
//		
//		if(providerUpdateDto.getLogo() != null) {
//		provider.setLogo(providerUpdateDto.getLogo());}
//		if(providerUpdateDto.getName() != null) {
//		provider.setName(providerUpdateDto.getName());}
//		provider.setFounded(providerUpdateDto.getFounded());
//		provider.setLanguages(providerUpdateDto.getLanguages());
//		provider.setIndustry(providerUpdateDto.getIndustry());
//		provider.setKeywords(providerUpdateDto.getKeywords());
//		provider.setProducts(providerUpdateDto.getProducts());
//		provider.setRating(providerUpdateDto.getRating());
//		provider.setReviews(providerUpdateDto.getReviews());
//		if (provider.getContactInfo() == null && providerUpdateDto.getContactInfo() != null) {
//			provider.setContactInfo(providerUpdateDto.getContactInfo());
//		} 
//		if (provider.getSocialMedia() == null && providerUpdateDto.getSocialMedia() != null) {
//			provider.setSocialMedia(providerUpdateDto.getSocialMedia());
//		} 
//		if (provider.getName() != null && provider.getIndustry() != null
//				&& provider.getProducts() != null && provider.getContactInfo() != null) {
//			provider.addRole("Authorized");
//		}
		
		providerRepository.save(provider);
		return modelMapper.map(provider, ProviderUpdateDto.class);
	}

	@Override
	public ProviderRemoveDto removeProvider(String email) {
		Provider provider = providerRepository.findByEmail(email).orElseThrow(ProviderNotFoundException::new);
		providerRepository.delete(provider);
		return modelMapper.map(provider, ProviderRemoveDto.class);
	}

	@Override
	public ProviderChangePasswordDto changePasswordProvider(ProviderChangePasswordDto providerChangePasswordDto) {
		Provider provider = providerRepository.findByEmail(providerChangePasswordDto.getEmail())
				.orElseThrow(ProviderNotFoundException::new);
		String password = passwordEncoder.encode(providerChangePasswordDto.getNewPassword());
		provider.setPassword(password);
		providerRepository.save(provider);
		return modelMapper.map(provider, ProviderChangePasswordDto.class);
	}

	@Override
	public ProviderDto getProvider(String email) {
		Provider provider = providerRepository.findByEmail(email).orElseThrow(ProviderNotFoundException::new);
		return modelMapper.map(provider, ProviderDto.class);
	}

}
