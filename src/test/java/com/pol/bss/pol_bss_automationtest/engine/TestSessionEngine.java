package com.pol.bss.pol_bss_automationtest.engine;

import java.util.HashMap;
import java.util.Map;

//TODO - We need to delete this class eventually

public class TestSessionEngine {

    private Map<String, Object> fixture;
    private static TestSessionEngine engine;

    private TestSessionEngine() {
        fixture = new HashMap<String, Object>();
    }

    public static TestSessionEngine getEngine() {
        if (engine == null)
            engine = new TestSessionEngine();
        return engine;
    }

    public Map<String, Object> getFixture() {
        return fixture;
    }

    public TestSessionEngine setFixture(Map<String, Object> fixture) {
        this.fixture = fixture;
        return this;
    }

    public TestSessionEngine put(String key, Object val) {
        this.fixture.put(key, val);
        return this;
    }

    public Object get(String key) {
        return this.fixture.get(key);
    }

    public <T> T getAs(String key, Class<T> clazz) {
        return clazz.cast(this.fixture.get(key));
    }

    public String getString(String key) {
        return getAs(key, String.class);
    }

    public void clear() {
        fixture = new HashMap<String, Object>();
    }
}
