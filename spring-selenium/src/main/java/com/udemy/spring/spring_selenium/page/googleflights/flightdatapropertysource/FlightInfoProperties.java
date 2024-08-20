package com.udemy.spring.spring_selenium.page.googleflights.flightdatapropertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("GoogleFlightLocale/id.properties") // This works
//@PropertySource("GoogleFlightLocale/${app.locale}.properties") // TODO: Commenting this line. But this works too. In the run configuration dialog, edit the environment variables and Add the name and value of the environment variable you want to pass, such as {app.locale}.
public class FlightInfoProperties {
    @Value("${flight.app.url}")
    private String url;

    @Value("${flight.app.labels}")
    private List<String> labels;

    public String getUrl() {
        return url;
    }

    public List<String> getLabels() {
        return labels;
    }
}
