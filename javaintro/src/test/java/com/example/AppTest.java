package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void validateVariables() {
        App app = new App();
        assertTrue(App.secretOfLife == 10);
        assertTrue(App.moneyInBalance == 100);
        assertTrue(App.distanceToSun == 149600000L);
        assertTrue(App.pi == 3.14f);
        assertTrue(App.name.equals("John Doe"));
        assertTrue(App.grade == 'A');
        assertTrue(App.alwaysTrue);
        assertTrue(App.distanceToMoon == 238855.0);
    }
}
