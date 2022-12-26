package tests.tags;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("needed")
public class DisabledTests {

    @Test
    void test1() {
        assertTrue(false);
    }

    @Test
    @Tag("prod")
    void test2() {
        assertTrue(false);
    }
}