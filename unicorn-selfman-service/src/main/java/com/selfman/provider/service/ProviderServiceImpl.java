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
		if (providerRepository.existsByEmail(providerRegisterDto.getEmail())) {
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

		if (provider.getName() != null && provider.getIndustry() != null
				&& provider.getProducts() != null && provider.getContactInfo() != null) {
			provider.addRole("VERIFIED");
		}
		
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
	public void changePasswordProvider(ProviderChangePasswordDto providerChangePasswordDto) {
		Provider provider = providerRepository.findByEmail(providerChangePasswordDto.getEmail())
				.orElseThrow(ProviderNotFoundException::new);
		String password = passwordEncoder.encode(providerChangePasswordDto.getNewPassword());
		provider.setPassword(password);
		providerRepository.save(provider);
	}

	@Override
	public ProviderDto getProvider(String email) {
		Provider provider = providerRepository.findByEmail(email).orElseThrow(ProviderNotFoundException::new);
		return modelMapper.map(provider, ProviderDto.class);
	}

}
