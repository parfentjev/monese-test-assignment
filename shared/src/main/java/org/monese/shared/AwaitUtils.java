package org.monese.shared;

import lombok.SneakyThrows;

import java.time.Instant;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class AwaitUtils {
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;

    /*
        Normally, I'd use WebDriverWait instead of writing my custom await.
        However, for some reason the Appium can't start the session if the
        webdriver-support is added as a dependency.

        I decided not to debug issues with external libraries, because that
        can take way too much time. For this little assignment, a trivial
        await method like this works just fine.

        Also, it's universal and can be used in API tests as well.
     */
    @SneakyThrows
    public static void await(Supplier<Boolean> condition) {
        Instant deadline = Instant.now().plusSeconds(DEFAULT_TIMEOUT_SECONDS);
        Boolean conditionValue;

        do {
            if ((conditionValue = condition.get())) {
                break;
            }

            Thread.sleep(1000);
        } while (Instant.now().isBefore(deadline));

        assertThat(conditionValue).isTrue();
    }
}
