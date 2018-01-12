package wagglegateway.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wagglegateway.clients.WaggleClient;

@Slf4j
@RestController
public class WaggleAdapterController {

    private final WaggleClient waggleClient;

    public WaggleAdapterController(WaggleClient waggleClient) {
        this.waggleClient = waggleClient;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck-waggle")
    public Object checkHealth() {
        log.info("Do the Waggle request:");
        String response = waggleClient.login();
        log.info("Response: {}", response);
        return response;
    }


}


