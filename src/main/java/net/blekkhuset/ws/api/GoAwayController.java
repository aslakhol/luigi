package net.blekkhuset.ws.api;

import java.util.concurrent.atomic.AtomicLong;

import net.blekkhuset.ws.model.GoAway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GoAwayController
{

    private static final String template = "Go away %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/goaway")
    public GoAway goAway(@RequestParam(value="name", defaultValue = "Mario") String name) {
        return new GoAway(counter.incrementAndGet(), String.format(template, name));
    }

}