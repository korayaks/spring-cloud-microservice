package com.korayaks.accountservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    @Value("${spcloud.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${spcloud.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spcloud.cassandra.port}")
    private int port;

    @Value("${spcloud.cassandra.username}")
    private String username;

    @Value("${spcloud.cassandra.password}")
    private String password;

    @Value("${spcloud.cassandra.base.packages}")
    private String basePackages;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }

    @Override
    public CassandraClusterFactoryBean cluster(){
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setPassword(password);
        clusterFactoryBean.setUsername(username);
        return clusterFactoryBean;
    }
}