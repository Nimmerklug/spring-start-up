package org.example.springboot.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndPoint {
    private final Map<String, MyFeature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndPoint() {
        featureMap.put("Department", new MyFeature(true));
        featureMap.put("Location", new MyFeature(true));
        featureMap.put("Student", new MyFeature(true));
        featureMap.put("User", new MyFeature(false));
        featureMap.put("Music", new MyFeature(false));
        featureMap.put("Authentication", new MyFeature(false));
    }

    @ReadOperation
    public Map<String, MyFeature> features() { //actuate endpoint features
        return featureMap;
    }

    @ReadOperation
    public MyFeature feature(@Selector String featureName) { //actuate endpoint feature
        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class MyFeature {
        private boolean isEnabled;
    }
}
