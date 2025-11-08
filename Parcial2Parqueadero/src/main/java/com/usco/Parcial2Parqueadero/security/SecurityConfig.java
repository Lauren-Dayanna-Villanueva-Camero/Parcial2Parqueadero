package com.usco.Parcial2Parqueadero.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MiUserDetailsService userDetailsService;

    public SecurityConfig(MiUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authenticationProvider())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/login/**", "/perform-login").permitAll()
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

                        // Swagger
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()

                        // Registros de Parqueadero - ADMINISTRADOR
                        .requestMatchers("/registro/nuevo", "/registro/editar/**",
                                "/registro/eliminar/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.POST, "/registro").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/registro/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/registro/**").hasRole("ADMINISTRADOR")

                        // Actualizar ubicación - ACOMODADOR y ADMINISTRADOR
                        .requestMatchers("/registro/actualizar-ubicacion/**").hasAnyRole("ADMINISTRADOR", "ACOMODADOR")

                        // Registrar salida - ACOMODADOR y ADMINISTRADOR
                        .requestMatchers("/registro/registrar-salida/**").hasAnyRole("ADMINISTRADOR", "ACOMODADOR")

                        // Ver registros - Todos los roles autenticados
                        .requestMatchers("/registro", "/registro/ver/**").hasAnyRole("ADMINISTRADOR", "ACOMODADOR", "CLIENTE")

                        // Gestión de tipos de vehículo - Solo ADMINISTRADOR
                        .requestMatchers("/tipo-vehiculo/**").hasRole("ADMINISTRADOR")

                        // Gestión de clientes - Solo ADMINISTRADOR
                        .requestMatchers("/cliente/**").hasRole("ADMINISTRADOR")

                        // API REST - Seguridad similar a las vistas
                        .requestMatchers(HttpMethod.GET, "/api/registros/**").hasAnyRole("ADMINISTRADOR", "ACOMODADOR", "CLIENTE")
                        .requestMatchers(HttpMethod.POST, "/api/registros/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/api/registros/**").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/api/registros/**").hasRole("ADMINISTRADOR")

                        .requestMatchers("/WEB-INF/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/perform-login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/acceso-denegado")
                );

        return http.build();
    }
}