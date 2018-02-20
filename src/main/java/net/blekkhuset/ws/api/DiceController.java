package net.blekkhuset.ws.api;

import net.blekkhuset.ws.model.Dice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@RestController
public class DiceController {

    private final AtomicLong counter = new AtomicLong();

    private final int[] allowedDice = {2, 4, 6, 8, 10, 12, 20};

    @RequestMapping("/roll")
    public Dice dice(@RequestParam(name="r", required=false) String diceRoll) {

        if (diceRoll != null) {
            Integer [] roll = Stream.of(diceRoll.split("d")).map(Integer::valueOf).toArray(Integer[]::new);
            isValidRoll(roll);

            return new Dice(counter.getAndIncrement(), roll[0], roll[1], diceRoll);
        } else {
            return new Dice(counter.getAndIncrement(), "1d6");
        }
    }

    private boolean isValidRoll(Integer[] roll) {
        if (roll.length != 2) {
            throw new IllegalArgumentException("Invalid input string.");
        } else if (!IntStream.of(allowedDice).anyMatch(x -> x == roll[1])) {
            throw new IllegalArgumentException("Only accepted dice sizes are d2, d4, d6, d8, d10, d12 and d20");
        } else {
            return true;
        }
    }
}
