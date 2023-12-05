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
import com.selfman.provider.exceptions.ProviderExistsExeption;
import com.selfman.provider.exceptions.ProviderNotFoundException;
import com.selfman.provider.model.ContactInfo;
import com.selfman.provider.model.Provider;
import com.selfman.provider.model.SocialMedia;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
	
	final ProviderRepository providerRepository;
	final ModelMapper modelMapper;
	final PasswordEncoder passwordEncoder;
	

	@Override
	public ProviderCreateDto createProvider(ProviderRegisterDto providerRegisterDto) {
		System.out.println("createProvider" + providerRegisterDto.getEmail());
		if(providerRepository.findById(providerRegisterDto.getEmail()).isPresent()) {
			throw new ProviderExistsExeption();
		}
		Provider provider = modelMapper.map(providerRegisterDto,Provider.class);
		String password = passwordEncoder.encode(providerRegisterDto.getPassword());
		provider.setPassword(password);
		providerRepository.save(provider);
		
		return modelMapper.map(provider, ProviderCreateDto.class);
	}

	@Override

	public ProviderDto updateProvider(String email, ProviderDto providerDto) {
		Provider provider = providerRepository.findById(email).orElseThrow(ProviderNotFoundException::new);
		provider.setLogo(provider.getLogo());
		provider.setName(providerDto.getName());
		provider.setEmail(provider.getEmail());
		provider.addIndustry(providerDto.getIndustry());
		provider.addKeyWord(providerDto.getKeywords());
		provider.addProduct(providerDto.getProducts());
		provider.addContactInfo(modelMapper.map(provider.getContactInfo(), ContactInfo.class));
		provider.addSocialMedia(modelMapper.map(provider.getSocialMedia(), SocialMedia.class));
		providerRepository.save(provider);
		return modelMapper.map(provider, ProviderDto.class);
	}

	@Override
	public ProviderRemoveDto removeProvider(String email) {
		Provider provider = providerRepository.findById(email).orElseThrow(ProviderNotFoundException::new);
		providerRepository.delete(provider);
		return modelMapper.map(provider, ProviderRemoveDto.class);
	}

	@Override
	public ProviderChangePasswordDto changePasswordProvider(ProviderChangePasswordDto providerChangePasswordDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProviderDto getProvider(String email) {
		Provider provider = providerRepository.findById(email).orElseThrow(ProviderNotFoundException::new);
		return modelMapper.map(provider, ProviderDto.class);
	}

}
