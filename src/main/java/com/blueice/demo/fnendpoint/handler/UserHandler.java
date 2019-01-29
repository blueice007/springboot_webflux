package com.blueice.demo.fnendpoint.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.blueice.demo.model.Result;
import com.blueice.demo.model.User;
import com.blueice.demo.service.UserService;

import reactor.core.publisher.Mono;

/**
* @Description: TODO
* @author blueice
* @date 2019年1月29日 上午10:46:24
*
*/
@Component
public class UserHandler
{
    @Autowired
    private UserService userService;
    
    public Mono<ServerResponse> findById(ServerRequest request){
        Mono<Result> mono = Mono.create(monoSink->{
            String param = request.pathVariable("id");
            if(param!=null) {
                monoSink.success(new Result(200,"success",userService.findById(Integer.valueOf(param))));
            }else {
                monoSink.success(new Result(404,"not found",null));
            }
        });
        
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(mono, Result.class);
    }
    
    public Mono<ServerResponse> findAll(ServerRequest request){
        Mono<Result> mono = Mono.create(monoSink->{
            List<User> all = userService.findAll();
            if(all!=null&&!all.isEmpty()) {
                monoSink.success(new Result(200,"success",all));
            }else {
                monoSink.success(new Result(404,"not found",null));
            }
        });
        
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(mono, Result.class);
    }
    
    public Mono<ServerResponse> add(ServerRequest request){
        Mono<Result> mono = request.bodyToMono(User.class).flatMap(user->{
            final Result result = new Result(200,"add success",userService.saveOrUpdate(user));
            return Mono.create(monoSink->monoSink.success(result));
        });
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(mono, Result.class);
    }
    
    public Mono<ServerResponse> update(ServerRequest request){
        Mono<Result> mono = request.bodyToMono(User.class).flatMap(user->{
            final Result result = new Result(200,"update success",userService.saveOrUpdate(user));
            return Mono.create(monoSink->monoSink.success(result));
        });
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(mono, Result.class);
    }
    
    public Mono<ServerResponse> delete(ServerRequest request){
        Mono<Result> mono = request.bodyToMono(User.class).flatMap(user->{
            final Result result = new Result(200,"delete success",userService.delete(user));
            return Mono.create(monoSink->monoSink.success(result));
        });
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(mono, Result.class);
    }
}
