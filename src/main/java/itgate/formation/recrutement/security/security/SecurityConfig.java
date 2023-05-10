package itgate.formation.recrutement.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login", "/admin/**", "/upload/**").permitAll();
        //tous permet creer login et register

        //  http.authorizeRequests().antMatchers("/user/**").hasAuthority("ADMIN");//




        http.authorizeRequests().antMatchers("/candidat/**").permitAll();

        http.authorizeRequests().antMatchers("/test/**").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/offre/**").permitAll();
        http.authorizeRequests().antMatchers("/getprofile/**").permitAll();
        http.authorizeRequests().antMatchers("/postuler/**").permitAll();
        http.authorizeRequests().antMatchers("/postuler/getAllId/**").permitAll();





        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);

    }


}



//li y5allini net7akem fi droit d'accées , generer l'autorité selon les roles
