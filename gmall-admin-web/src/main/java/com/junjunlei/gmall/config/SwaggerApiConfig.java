package com.junjunlei.gmall.config;

import com.junjunlei.gmall.pms.controller.PmsBrandController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Api Config
 *
 * @author junjun.lei
 * @create 2020-03-07 17:11
 */
@Configuration
@EnableSwagger2
public class SwaggerApiConfig {
    /**
     * 后台用户管理
     */
    public static final String UMS_ADMIN_CONTROLLER = "UmsAdminController";
    /**
     * 商品管理
     */
    public static final String PMS_PRODUCT_CONTROLLER = "PmsProductController";
    /**
     * 商品品牌管理
     */
    public static final String PMS_BRAND_CONTROLLER="PmsBrandController";
    /**
     * 会员等级管理
     */
    public static final String UMS_MEMBER_LEVEL_CONTROLLER="UmsMemberLevelController";

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag(UMS_ADMIN_CONTROLLER, "后台用户管理"),
                        new Tag(PMS_PRODUCT_CONTROLLER ,"商品管理"),
                        new Tag(PMS_BRAND_CONTROLLER ,"商品品牌管理"),
                        new Tag(UMS_MEMBER_LEVEL_CONTROLLER ,"会员等级管理"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.junjunlei.gmall"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商城-后台管理系统平台接口文档")
                .description("提供pms、oms、ums、cms、sms模块的文档")
                .termsOfServiceUrl("http://www.junjunlei.com/")
                .version("1.0")
                .build();
    }
}
