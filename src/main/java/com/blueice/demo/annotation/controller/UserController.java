package com.blueice.demo.annotation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueice.demo.model.User;
import com.blueice.demo.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
* @Description: TODO
* @author blueice
* @date 2019年1月28日 下午6:12:22
*
*/
//@RestController
//@RequestMapping("/api_anno/users")
public class UserController
{
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable int id){
        Mono<User> mono = Mono.create(monoSink->{
            //此处为异步操作
            monoSink.success(userService.findById(id));
        });
        return mono;
    }
    
    @GetMapping("")
    public Flux<User> findAll(){
        Flux<User> flux = Flux.create(fluxSink->{
            //此处为异步操作
            List<User> all = userService.findAll();
            if(all!=null&&!all.isEmpty()) {
                all.forEach(user->{
                    fluxSink.next(user);
                });
                fluxSink.complete();
            }
        });
        return flux;
    }
    
    @PostMapping("/add")
    public Mono<User> add(@RequestBody User user){
        Mono<User> mono = Mono.create(monoSink->{
            //此处为异步操作
            monoSink.success(userService.saveOrUpdate(user));
        });
        return mono;
    }
    
    @PutMapping("/update")
    public Mono<User> update(@RequestBody User user){
        Mono<User> mono = Mono.create(monoSink->{
            //此处为异步操作
            monoSink.success(userService.saveOrUpdate(user));
        });
        return mono;
    }
    
    @DeleteMapping("/{id}")
    public Mono<User> deleteById(@PathVariable int id){
        Mono<User> mono = Mono.create(monoSink->{
            //此处为异步操作
            monoSink.success(userService.delete(new User(id, null, 0, null)));
        });
        return mono;
    }
}
