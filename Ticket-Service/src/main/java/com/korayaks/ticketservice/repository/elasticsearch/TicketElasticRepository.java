package com.korayaks.ticketservice.repository.elasticsearch;

import com.korayaks.ticketservice.model.elasticsearch.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {
}
