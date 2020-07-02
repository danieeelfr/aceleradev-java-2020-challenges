package core;

import core.PublisherApplication.PubsubOutboundGateway;
import models.LogInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ApiController {

    @Autowired
    private PubsubOutboundGateway messagingGateway;

    @PostMapping(path = "/create")
    public String create(@RequestBody LogInputDTO input) {
        try {
            messagingGateway.sendToPubsub(input);
            return "Log sent to PubSub!";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @PostMapping("/add")
    public RedirectView add(@RequestParam("title") String title, @RequestParam("message") String message, @RequestParam("times") int times) {
        
        for (int x=1; x<=times; x++) {
            LogInputDTO dto = new LogInputDTO(x + "-" + title, x + "-" + message);
            messagingGateway.sendToPubsub(dto);
        }
        
        return new RedirectView("/");
    }
}
