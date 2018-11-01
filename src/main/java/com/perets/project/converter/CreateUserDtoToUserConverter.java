package com.perets.project.converter;

import com.perets.project.domain.Role;
import com.perets.project.domain.User;
import com.perets.project.dto.CreateUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToUserConverter implements Converter<CreateUserDto, User> {

    @Override
    public User convert(@NonNull CreateUserDto source) {
        User user = new User();
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setEmail(source.getEmail());
        user.setRole(Role.getRole(source.getRole()));
        return user;
    }
}
