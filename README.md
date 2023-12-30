## Overview

This repository contains a project that explores Spring Security version 3, incorporating new features while addressing the deprecation of older interfaces. The project also integrates OpenAPI for API documentation and includes auditing functionalities.

## Features

### 1. Spring Security 3

In this project, we leverage Spring Security version 3 to enhance the security aspects of the application. This includes adopting new features and adapting to changes in the framework.

### 2. Interface Deprecation

With the evolution of Spring Security, certain interfaces have been deprecated in favor of more modern and efficient alternatives. This repository serves as a guide to handling these deprecations and adopting the recommended practices.

### 3. OpenAPI Integration

The project integrates OpenAPI for better API documentation and exploration. OpenAPI provides a standardized way to describe RESTful APIs, making it easier for developers to understand and consume your API.

### 4. Auditing

Auditing is a crucial aspect of application development, especially when it comes to tracking changes and monitoring user activities. This project incorporates auditing functionalities to keep track of relevant events within the system.

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository: `https://github.com/moeenScape/spring-security.git`
2. Install dependencies: `./gradlew build`
3. Run the application: `./gradlew bootRun`

# Spring Security 3 - Security Enhancements

## Overview

This repository explores the security-related updates introduced in Spring Security 3. It discusses key changes, deprecations, and new features in the security module, providing examples and recommendations for developers adopting this version.
```java
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(SKIPED_URL)
                                .permitAll()
                                .requestMatchers("/api/v1/management/**")
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
```

## Security Enhancements
### 1. Removal of WebSecurityConfigurerAdapter

In Spring Security 3, the `WebSecurityConfigurerAdapter` class, previously used for configuring security settings, has been deprecated and removed. Instead, a more component-based approach is encouraged, where developers should create a bean of type `SecurityFilterChain` for security configuration.

Example:

```java
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Your security configurations here
            .authorizeHttpRequests(authorize -> authorize
                .mvcMatchers("/api/auth").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
```

### 2. authorizeHttpRequests Method

The authorizeHttpRequests method is introduced in the HttpSecurity configuration, replacing the deprecated authorizeRequests. It allows for fine-grained request matching for access control.
```java
http
    .authorizeHttpRequests(authorize -> authorize
        .mvcMatchers("/api/auth").permitAll()
        .anyRequest().authenticated()
    );
```
### 3. Path-Based Access Control using requestMatchers

In Spring Security 3, AntMatcher, MvcMatcher, and RegexMatcher have been deprecated and replaced by requestMatchers or securityMatchers for path-based access control. This allows matching requests based on patterns or other criteria without relying on specific matchers.

```java
http
    .requestMatchers(matcher -> matcher
        .antMatchers("/api/auth").permitAll()
        .anyRequest().authenticated()
    );

```
