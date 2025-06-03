package com.gnr.spot_media.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                /**
                 * Desactivamos las defensas contra csrf ya que son solo necesarias en formularios
                 */
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Habilita CORS
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req ->
                        req
                                .anyRequest().permitAll())
                .httpBasic(AbstractHttpConfigurer::disable)
                /**
                 * Establecemos de que manera va a trabajar la sesion. Con STATELESS le decimos que no guarde la sesion en memoria.
                 */
                .logout(logout ->
                        logout.logoutUrl("/auth/logout")
                                /*.addLogoutHandler((request, response, authentication) -> {
                                    String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
                                })*/
                                .logoutSuccessHandler((request, response, authentication) ->
                                        SecurityContextHolder.clearContext()))
                /**
                 * De esta manera podemos configurar de que forma se va a poder acceder a cada uno de los endpoints.
                 * Hay otra manera de hacer esto y es con notaciones, lo que simplificaria mucho mas el codigo.
                 */
                /*.authorizeHttpRequests(http -> {
                    /// Configurar endpoints publicos
                    http.requestMatchers(HttpMethod.GET, "/api/book/all").hasAuthority("READ");

                    /// Configurar endpoints privados
                    http.requestMatchers(HttpMethod.DELETE, "/api/book/{id}").hasAuthority("DELETE");

                    /// Configurar el resto de endpoints - NO ESPECIFICADOS
                    http.anyRequest().denyAll(); //Niega toda peticion a un endpoint no especificado
                    //http.anyRequest().authorize(); Solo permite peticiones autenticadas a endpoints no especificados
                })*/
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:4000", "https://spotmediainc.com", "https://www.spotmediainc.com")); // Permite solicitudes desde este origen
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Encabezados permitidos
        configuration.setAllowCredentials(true); // Permite credenciales (cookies, encabezados de autenticación)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica la configuración a todas las rutas
        return source;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}