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
		System.out.println("createProvider   " + providerRegisterDto.getEmail());
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

	public ProviderUpdateDto updateProvider(String email, ProviderUpdateDto providerUpdateDto) {
		System.out.println("updateProvider  " + email);
		Provider provider = providerRepository.findById(email).orElseThrow(ProviderNotFoundException::new);
		provider.setLogo(provider.getLogo());
		provider.setName(providerUpdateDto.getName());
		provider.setEmail(provider.getEmail());
		provider.setIndustry(providerUpdateDto.getIndustry());
		provider.setKeywords(providerUpdateDto.getKeywords());
		provider.setProducts(providerUpdateDto.getProducts());
		provider.setContactInfo(provider.getContactInfo());
		provider.setSocialMedia(provider.getSocialMedia());
		if(provider.getCountry() != null && provider.getName() != null && provider.getIndustry() != null
				&& provider.getProducts() != null && provider.getContactInfo() != null
				) {
			provider.addRole("Authorized");
		}
		providerRepository.save(provider);
		return modelMapper.map(provider, ProviderUpdateDto.class);
	}

	@Override
	public ProviderRemoveDto removeProvider(String email) {
		System.out.println("removeProvider  " + email);
		Provider provider = providerRepository.findById(email).orElseThrow(ProviderNotFoundException::new);
		providerRepository.delete(provider);
		return modelMapper.map(provider, ProviderRemoveDto.class);
	}

	@Override
	public ProviderChangePasswordDto changePasswordProvider(String email, String newPassword) {
		System.out.println("changePasswordProvider  " + email);
		Provider provider = providerRepository.findById(email).orElseThrow(ProviderNotFoundException::new);
		String password = passwordEncoder.encode(newPassword);
		provider.setPassword(password);
		providerRepository.save(provider);
		return modelMapper.map(provider, ProviderChangePasswordDto.class);
	}

	@Override
	public ProviderDto getProvider(String email) {
		System.out.println("getProvider  " + email);
		Provider provider = providerRepository.findById(email).orElseThrow(ProviderNotFoundException::new);
		return modelMapper.map(provider, ProviderDto.class);
	}

}
