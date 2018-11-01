package com.perets.project.converter;

import com.perets.project.domain.User;
import com.perets.project.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(@NonNull User source) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(source.getFirstName());
        userDto.setLastName(source.getLastName());
        userDto.setEmail(source.getEmail());
        userDto.setStatus(source.getStatus().getName());
        userDto.setRoleName(source.getRole().getName());
        return userDto;
    }
}
