package com.example.hotdesk;

import com.example.hotdesk.security.SessionUser;
import com.example.hotdesk.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;

@EnableJpaAuditing
@RequiredArgsConstructor
@SpringBootApplication
public class HotDeskApplication implements CommandLineRunner
{
    private final SessionUser sessionUser;
    private final UserService userService;
    public static void main( String[] args )
    {
        SpringApplication.run( HotDeskApplication.class, args );
    }

    // to do forgot-password
    // reserve desk
    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        RedisStandaloneConfiguration localhost = new RedisStandaloneConfiguration( "localhost", 1818 );
        return new JedisConnectionFactory( localhost );
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate()
    {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory( jedisConnectionFactory() );
        return template;
    }

    @Bean
    public AuditorAware<Integer>auditorAware(){
        return () -> Optional.of(sessionUser.id());
    }

    @Override
    public void run(String... args) throws Exception {
//        userService.initializeAdmin();
    }



}
