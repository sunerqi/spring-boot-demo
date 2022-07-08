package com.sunhl.swagger2;

import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunhailong
 * @Date: 2022/7/7 15:39
 * @Desc: swagger2配置类
 * http://localhost:8080/swagger-ui.html#/
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi() {
        List<Parameter> pars = getParameters();
        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
        ApiSelectorBuilder selector = docket.select();
        // api接口包扫描路径
        List<Predicate<RequestHandler>> list = this.buildPackage();
//        if (list == null || list.isEmpty()) {
//            // api的配置路径
//            // 未配置，默认一个不存在的路径，避免扫描整个项目路径;下的类，才生成接口文档
//            selector.apis(RequestHandlerSelectors.basePackage("com.sunhl.**.controller"));
//        } else if (list.size() == 1) {
//            selector.apis(list.get(0));//
//        } else if (list.size() > 1) {
//            selector.apis(Predicates.or(list));
//        }
        // 扫描路径选择;可以根据url路径设置哪些请求加入文档，忽略哪些请求
        selector.paths(PathSelectors.any())
                // 加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build().globalOperationParameters(pars);
        return docket;
    }

    /**
     * swagger文档基本信息页面
     *
     * @return
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("二七swagger2-UI接口文档")
                // 文档描述
                .description("了解更多请联系技术人员")
                // 文档版本
                .version("1.0")
                // 服务的域名
//                .termsOfServiceUrl(String.format("url"))
                // 联系人实体信息
                .contact(new Contact("二七", "www.sunhl.cn", "sunerqi@qq.com"))
                .build();
    }

    /**
     * 请求接口全局参数配置
     *
     * @return
     */
    public static List<Parameter> getParameters() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token").description("系统登录凭证").modelRef(new ModelRef("String")).parameterType("header").required(false);
        List<Parameter> pars = new ArrayList<Parameter>();
        pars.add(tokenPar.build());
        return pars;
    }

    private List<Predicate<RequestHandler>> buildPackage() {
        List<Predicate<RequestHandler>> result = new ArrayList<Predicate<RequestHandler>>();
        String value = System.getProperties().getProperty("swagger-api-package");
        if (value == null || value.trim().equals("")) {
            return result;
        }
        String[] packageArr = value.split(";");
        for (String str : packageArr) {
            if (str == null || str.trim().equals("")) {
                continue;
            }
            result.add(RequestHandlerSelectors.basePackage(str));
        }
        return result;
    }
}
