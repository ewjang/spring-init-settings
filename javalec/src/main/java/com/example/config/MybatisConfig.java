package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.mapper", sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class MybatisConfig {
	
	@Bean
	@Primary
	@ConfigurationProperties("spring.oracle.datasource")
	public DataSourceProperties dataSourceProperties() {
	    return new DataSourceProperties();
	}
	
	@Primary
	@Bean
	@ConfigurationProperties("spring.oracle.datasource.configuration")
	public DataSource dataSource(DataSourceProperties properties) {

		properties.setUrl(properties.getUrl());
		properties.setUsername(properties.getUsername());
		properties.setPassword(properties.getPassword());
		
	    return properties.initializeDataSourceBuilder().build();
	}
	
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	
    @Primary
    @Bean
    public SqlSessionFactory oracleSqlSessionFactory(DataSource oracleDataSource) throws Exception {
    	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    	SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oracleDataSource);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml")); // MyBatis 매퍼 파일의 위치를 설정
        
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.getObject().getConfiguration().setCallSettersOnNulls(true);
        sqlSessionFactoryBean.getObject().getConfiguration().setCacheEnabled(false);
        sqlSessionFactoryBean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        return sqlSessionFactoryBean.getObject();
    }
    
    @Primary
    @Bean
    public SqlSessionTemplate mssqlSqlSessionTemplate(SqlSessionFactory oracleSqlSessionFactory) throws Exception {
    	
        return new SqlSessionTemplate(oracleSqlSessionFactory);
    }
    
    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(DataSource dataSource) throws Exception
    {
    	
        return new DataSourceTransactionManager(dataSource);
    }
    
}
