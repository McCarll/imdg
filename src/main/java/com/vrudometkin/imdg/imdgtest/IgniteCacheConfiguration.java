package com.vrudometkin.imdg.imdgtest;

import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.ClientCacheConfiguration;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.expiry.ExpiryPolicy;
import java.util.concurrent.TimeUnit;

@Configuration
public class IgniteCacheConfiguration {
    @Bean
    ClientCache cache(){
        ClientConfiguration cfg = new ClientConfiguration();
        cfg.setAddresses("127.0.0.1:10800");
        ClientCacheConfiguration cacheConfiguration = new ClientCacheConfiguration();
        cacheConfiguration.setName("product_id1");
        ExpiryPolicy expiryPolicy = new CreatedExpiryPolicy(new Duration(TimeUnit.SECONDS, 10));
        cacheConfiguration.setExpiryPolicy(expiryPolicy);
        IgniteClient igniteClient = Ignition.startClient(cfg);
        return igniteClient.getOrCreateCache(cacheConfiguration);
    }
}
