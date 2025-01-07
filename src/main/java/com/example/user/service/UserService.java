package com.example.user.service;


import com.example.user.dto.UserDTO;
import com.example.user.model.Address;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setGender(userDTO.getGender());
        user.setSalary(userDTO.getSalary());
        user.setDepartment(userDTO.getDepartment());
        user.setHobbies(userDTO.getHobbies());
        user.setDoj(userDTO.getDoj());

        List<Address> addresses = new ArrayList<>();
        if (userDTO.getAddress() != null) {
            userDTO.getAddress().forEach(dtoAddress -> {
                Address address = new Address();
                address.setAddressLine1(dtoAddress.getAddressLine1());
                address.setAddressLine2(dtoAddress.getAddressLine2());
                address.setCity(dtoAddress.getCity());
                address.setState(dtoAddress.getState());
                address.setCountry(dtoAddress.getCountry());
                address.setZipCode(dtoAddress.getZipCode());
                address.setUser(user); // Set the Employee reference
                addresses.add(address);
            });
        }
        user.setAddress(addresses);
        return mapToDTO(userRepository.save(user));

    }

    private UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setSalary(user.getSalary());
        userDTO.setDepartment(user.getDepartment());
        userDTO.setHobbies(user.getHobbies());
        userDTO.setDoj(user.getDoj());
        return userDTO;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User Not found"));
    }
}
