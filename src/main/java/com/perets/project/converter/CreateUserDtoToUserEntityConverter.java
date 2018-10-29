package com.perets.project.converter;

import com.perets.project.domain.User;
import com.perets.project.dto.CreateUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToUserEntityConverter implements Converter<CreateUserDto, User> {

    @Override
    public User convert(@NonNull CreateUserDto source) {
        User user = new User();
        user.setFullName(source.getFullName());
        user.setEmail(source.getEmail());
        return user;
    }
}
