package com.perets.project.persistence;

import com.perets.project.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserElasticRepository extends ElasticsearchRepository<User, String> {
}
