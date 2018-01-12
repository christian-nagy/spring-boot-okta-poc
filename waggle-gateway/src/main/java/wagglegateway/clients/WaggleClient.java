package wagglegateway.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("GolfWaggle")
public interface WaggleClient {


    // Adjust the zuul path in the config file for this to work, otherwise zuul will just forward the request
    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck", produces = "text/plain")
    String login();
}
