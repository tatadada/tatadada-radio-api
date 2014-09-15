package com.tatadada.api;

import com.jayway.restassured.RestAssured;
import com.tatadada.api.entity.Channel;
import com.tatadada.api.model.ChannelRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.when;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ChannelControllerTest {

    @Autowired
    ChannelRepository repository;

    Channel channel1;
    Channel channel2;


    @Value("${local.server.port}")
            int port;

    //TODO setup the test server

    @Ignore
    @Before
    public void setUp() {
        channel1 = new Channel("title1", "subtitle1", "streamurl1", "resource1");
        channel2 = new Channel("title2", "subtitle2", "streamurl2", "resource2");


        repository.save(Arrays.asList(channel1, channel2));


        RestAssured.port = port;
    }

    @Ignore
    @Test
    public void canFetch() {
        long channel1Id = channel1.getId();

        when().
                get("/radio/service/tatadadaradio/v1?did=12345667890", channel1Id).
                then().
                statusCode(OK.value()).
                body("name", Matchers.is("Mickey Mouse")).
                body("id", Matchers.is(channel1Id));
    }



}