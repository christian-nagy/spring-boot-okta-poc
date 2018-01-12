package wagglegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@EnableOAuth2Sso
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class WaggleGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaggleGatewayApplication.class, args);
    }
}
