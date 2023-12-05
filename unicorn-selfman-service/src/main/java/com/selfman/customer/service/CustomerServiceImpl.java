package com.selfman.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.selfman.customer.dao.CustomerRepository;
import com.selfman.customer.dto.CustomerDto;
import com.selfman.customer.dto.CustomerExtendedDto;
import com.selfman.customer.dto.CustomerRegisterDto;
import com.selfman.customer.dto.CustomerRemoveDto;
import com.selfman.customer.dto.CustomerUpdateDto;
import com.selfman.customer.dto.RolesCustomerDto;
import com.selfman.customer.dto.exceptions.CustomerExistsExeption;
import com.selfman.customer.dto.exceptions.CustomerNotFoundException;
import com.selfman.customer.model.Customer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService, CommandLineRunner {

	final CustomerRepository customerRepository;
	final ModelMapper modelMapper;
	final PasswordEncoder passwordEncoder;

	@Override
	public CustomerDto registerCustomer(CustomerRegisterDto customerRegisterDto) {
		if (customerRepository.existsById(customerRegisterDto.getEmail())) {
			throw new CustomerExistsExeption("Customer with email: " + customerRegisterDto.getEmail() + " exist");
		}
		Customer customer = modelMapper.map(customerRegisterDto, Customer.class);
		customer.addRole("CUSTOMER");
		String password = passwordEncoder.encode(customerRegisterDto.getPassword());
		customer.setPassword(password);
		customerRepository.save(customer);
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public CustomerExtendedDto getCustomer(String email) {
		Customer customer = customerRepository.findById(email).orElseThrow(CustomerNotFoundException::new);
		return modelMapper.map(customer, CustomerExtendedDto.class);
	}

	@Override
	public CustomerRemoveDto removeCustomer(String email) {
		Customer customer = customerRepository.findById(email).orElseThrow(CustomerNotFoundException::new);
		customerRepository.delete(customer);
		return modelMapper.map(customer, CustomerRemoveDto.class);
	}

	@Override
	public CustomerExtendedDto updateCustomer(String email, CustomerUpdateDto customerExtendedDto) {
		Customer customer = customerRepository.findById(email).orElseThrow(CustomerNotFoundException::new);
		customer.setFirstName(customerExtendedDto.getFirstName());
		customer.setLastName(customerExtendedDto.getLastName());
		customer.setCountry(customerExtendedDto.getCountry());
		customer.setCity(customerExtendedDto.getCity());
		customer.setStreet(customerExtendedDto.getStreet());
		customer.setBuilding(customerExtendedDto.getBuilding());
		customer.setZipcode(customerExtendedDto.getZipcode());
		customer.setPhoneNumber(customerExtendedDto.getPhoneNumber());
		if (customer.getCity() != null && customer.getStreet() != null && customer.getBuilding() != null
				&& customer.getPhoneNumber() != null) {
			customer.addRole("VERIFIED");
		}
		customerRepository.save(customer);
		return modelMapper.map(customer, CustomerExtendedDto.class);
	}

	@Override
	public RolesCustomerDto changeRolesListCustomer(String email, String role, boolean isAddRole) {

		Customer customer = customerRepository.findById(email).orElseThrow(CustomerNotFoundException::new);
		boolean res;
		if (isAddRole) {
			res = customer.addRole(role.toUpperCase());
		} else {
			res = customer.removeRole(role.toUpperCase());
		}
		if (res) {
			customerRepository.save(customer);
		}
		return modelMapper.map(customer, RolesCustomerDto.class);

	}

	@Override
	public void changePasswordCustomer(String email, String newPassword) {
		Customer customer = customerRepository.findById(email).orElseThrow(CustomerNotFoundException::new);
		String password = passwordEncoder.encode(newPassword);
		customer.setPassword(password);
		customerRepository.save(customer);
	}

	@Override
	public void run(String... args) throws Exception {
		if (customerRepository.findById("admin").isEmpty()) {
			String password = passwordEncoder.encode("admin");
			Customer customer = new Customer("admin", "admin", "admin", password, "");
			customer.addRole("ADMINISTRATOR");
			customerRepository.save(customer);
		}
	}

}
