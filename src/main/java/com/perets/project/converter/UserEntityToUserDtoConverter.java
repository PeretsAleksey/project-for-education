package com.perets.project.converter;

import com.perets.project.domain.User;
import com.perets.project.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(@NonNull User source) {
        UserDto userDto = new UserDto();
        userDto.setFullName(source.getFullName());
        userDto.setEmail(source.getEmail());
        userDto.setDateAdded(source.getDateAdded());
        return userDto;
    }
}
