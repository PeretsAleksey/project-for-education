package com.perets.project.service;

import com.perets.project.dto.PageDto;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ExtendedConversionService extends ConversionService {

    <T> List<T> convertAll(Collection<?> source, Class<T> targetClass);

    <T> Set<T> convertSet(Collection<?> source, Class<T> targetClass);

    <T> PageDto<T> convertPage(Page<?> page, Class<T> targetClass);
}
