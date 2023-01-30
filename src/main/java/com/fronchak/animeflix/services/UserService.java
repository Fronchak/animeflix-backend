package com.fronchak.animeflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fronchak.animeflix.dtos.user.UserInputDTO;
import com.fronchak.animeflix.dtos.user.UserOutputDTO;
import com.fronchak.animeflix.entities.User;
import com.fronchak.animeflix.exceptions.ResourceNotFoundException;
import com.fronchak.animeflix.mappers.UserMapper;
import com.fronchak.animeflix.repositories.RoleRepository;
import com.fronchak.animeflix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public UserOutputDTO save(UserInputDTO inputDTO) {
		User entity = new User();
		copyDTOToEntity(inputDTO, entity);
		entity = repository.save(entity);
		return mapper.convertEntityUserToUserOutputDTO(entity);
	}
	
	private void copyDTOToEntity(UserInputDTO dto, User entity) {
		entity.setEmail(dto.getEmail());
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity.addRoles(roleRepository.getReferenceById(1L));
	}
	
	@Transactional(readOnly = true)
	public UserOutputDTO findById(Long id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", id.toString()));
		return mapper.convertEntityUserToUserOutputDTO(entity);
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
}
