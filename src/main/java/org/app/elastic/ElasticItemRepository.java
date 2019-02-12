package org.app.elastic;

import org.app.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ElasticItemRepository extends ElasticsearchRepository<Product, Long> {
}
