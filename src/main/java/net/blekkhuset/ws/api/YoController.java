package net.blekkhuset.ws.api;

import java.util.concurrent.atomic.AtomicLong;

import net.blekkhuset.ws.model.Yo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class YoController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/yo")
    public Yo yo(@RequestParam(value="name", required=false) String name) {
        if (name != null) {
            return new Yo(counter.incrementAndGet(), String.format("yo %s!", name));
        }
        return new Yo(counter.incrementAndGet(), "yo");
    }
}
