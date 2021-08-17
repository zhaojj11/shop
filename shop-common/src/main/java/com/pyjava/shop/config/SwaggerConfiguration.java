package com.pyjava.shop.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述: swagger 配置类 </p>
 *
 * @author zhaojj11
 * @since 1.0
 */
@Component
@Data
@EnableOpenApi
public class SwaggerConfiguration {
    @Bean
    public Docket webApiDoc() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("用户端接口文档")
                .pathMapping("/")
                // 定义是否开启swagger, 可以通过变量配置它
                .enable(true)
                // 配置文档的元信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pyjava.shop"))
                // 正则匹配请求路径,并分配当前分组
                .paths(PathSelectors.ant("api/**"))
                .build()
                .globalRequestParameters(globalRequestParameters())
                .globalResponses(HttpMethod.GET, getGlobalResponseMessage());
    }

    @Bean
    public Docket adminApiDoc() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("管理端接口文档")
                .pathMapping("/")
                // 定义是否开启swagger, 可以通过变量配置它
                .enable(true)
                // 配置文档的元信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pyjava.shop"))
                // 正则匹配请求路径,并分配当前分组
                .paths(PathSelectors.ant("admin/**"))
                .build();

    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("电商平台")
                .description("微服务接口文档")
                .version("v1.0")
                .contact(new Contact("zhaojj", "http://pyjava.com", "757355084@qq.com"))
                .build();
    }

    private List<RequestParameter> globalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("token")
                .description("登录令牌")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());

        return parameters;
    }

    private List<Response> getGlobalResponseMessage() {
        List<Response> list = new ArrayList<>();

        list.add(new ResponseBuilder()
                .code("4xx")
                .description("请求错误,根据code和msg检查")
                .build());
        return list;
    }
}
