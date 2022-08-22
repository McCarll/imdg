package com.vrudometkin.imdg.imdgtest;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.cql.WriteOptions;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@EnableCaching
@EnableCassandraRepositories
public class IgniteCacheConfiguration {
    @Bean
    public CassandraMappingContext cassandraMapping() {
        return new CassandraMappingContext();
    }

    @Bean
    WriteOptions writeOptions() {
        WriteOptions writeOptions = WriteOptions.builder().ttl(Duration.of(60, ChronoUnit.SECONDS)).build();
        return writeOptions;
    }
}
