package com.tatadada.api;

import com.tatadada.api.model.Channel;
import com.tatadada.api.model.ChannelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);

        ChannelRepository repository = ctx.getBean(ChannelRepository.class);

        // save a couple of customers
        repository.save(new Channel("Title 1", "suptitle1", "http://pippo.com", "risorsa"));

        final List<Channel> risorsa = repository.findByResource("risorsa");

        System.out.println(risorsa);

    }

}