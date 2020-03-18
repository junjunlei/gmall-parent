package com.junjunlei.gmall.pms.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 配置类
 * @author junjun.lei
 * @create 2020-03-06 18:52
 */
@Configuration
public class ShardingJdbcConfiguration {

    @Bean
    public DataSource dataSource() throws IOException, SQLException {
        File file = ResourceUtils.getFile("classpath:sharding-jdbc.yml");
        DataSource dataSource= MasterSlaveDataSourceFactory.createDataSource(file);
        return dataSource;
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
