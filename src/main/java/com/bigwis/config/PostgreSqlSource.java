package com.bigwis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * PostGreSql 数据源配置
 * Created by GanZiB on 2017/4/11.
 */
@Configuration
@MapperScan(basePackages = "com.bigwis.mapper.postgresql",sqlSessionTemplateRef = "SessionTemplate")
public class PostgreSqlSource {
    @Bean(name = "postgresqlDataSource")
    @ConfigurationProperties(prefix="spring.datasource.postgresql")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "PostGreSqlSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("postgresqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("postgresqlDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("PostGreSqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
