package com.bobocode.config;

import static org.springframework.context.annotation.ComponentScan.Filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This class provides application root (non-web) configuration for a basic spring application context
 * (containing middle-tire services, datasource, etc.).
 * The configuration must exclude the web layer of the application.
 * <p>
 */
@Configuration
@ComponentScan(value = "com.bobocode", excludeFilters = { @Filter(Controller.class), @Filter(EnableWebMvc.class) })

public class RootConfig {
}
