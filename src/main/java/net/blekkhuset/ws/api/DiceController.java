package net.blekkhuset.ws.api;

import net.blekkhuset.ws.model.Dice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;


@RestController
public class DiceController {

    private final AtomicLong counter = new AtomicLong();

    private final int[] allowedDice = {2, 4, 6, 8, 10, 12, 20};

    @RequestMapping("/roll")
    public Dice dice(@RequestParam(name="r", required=false) String diceRoll) {
        if(false){

            throw new IllegalArgumentException("Only accepted dice sizes are d2, d4, d6, d8, d10, d12 and d20");
        }

        if (diceRoll != null) {
            String[] roll = diceRoll.split("d");
            return new Dice(counter.getAndIncrement(), Integer.parseInt(roll[0]), Integer.parseInt(roll[1]), diceRoll);
        } else {
            return new Dice(counter.getAndIncrement(), "1d6");
        }
    }

    private boolean isValidRoll(String[] roll) {
        if (roll.length != 2) {
            return false;
        } else if (!IntStream.of(allowedDice).anyMatch(x -> x == 4)) {
            return false;
        } else {
            return true;
        }
    }
}
