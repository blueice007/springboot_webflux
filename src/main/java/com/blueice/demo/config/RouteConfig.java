package com.blueice.demo.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.blueice.demo.fnendpoint.handler.UserHandler;

/**
* @Description: TODO
* @author blueice
* @date 2019年1月29日 上午10:48:47
*
*/
@Configuration
public class RouteConfig
{
    @Autowired
    private UserHandler userHandler;
    
    @Bean
    public RouterFunction<ServerResponse> userRouter(){
        return RouterFunctions
        .route(GET("/api_fn/users/{id}"),userHandler::findById)
        .andRoute(GET("/api_fn/users"), userHandler::findAll)
        .andRoute(DELETE("/api_fn/users"), userHandler::delete)
        .andRoute(POST("/api_fn/users"), userHandler::add)
        .andRoute(PUT("/api_fn/users"), userHandler::update);
    }
}
