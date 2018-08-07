package com.lizhigang.web.filter;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * author : lizhigang
 * time : 2018-08-03
 */
@Configuration
@MapperScan("com.lizhigang.api.dao")
public class MybatisConfig {

    @Value("${mybatis.config-location}")
    private String mapperLocationPattern;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        DataSource dataSource = new com.alibaba.druid.pool.DruidDataSource();
        return dataSource;
    }

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocationPattern));
        return sqlSessionFactoryBean.getObject();
    }
}
