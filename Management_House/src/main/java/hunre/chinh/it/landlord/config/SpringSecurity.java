package hunre.chinh.it.landlord.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
  @Autowired
  private UserDetailsService userDetailsService;

  @Bean
  public static PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests((authorize) ->
            authorize.requestMatchers("/register/**").permitAll()
                .requestMatchers("/index").permitAll()
                .requestMatchers("/static/css/**").permitAll()
                .requestMatchers("/static/images/**").permitAll()
                .requestMatchers("/static/js/**").permitAll()
                //.requestMatchers("/loginSuccess").hasRole("USER")
                .requestMatchers("/houses_create").hasRole("USER")
                .requestMatchers("/available_users").hasRole("USER")
                .requestMatchers("/home_landlord").hasRole("USER")

                .requestMatchers("/manageHouses/{idHouse}").hasRole("USER")
                .requestMatchers("/available_houses").hasRole("USER")
                .requestMatchers("/save_houses").hasRole("USER")
                .requestMatchers("/houses_register").hasRole("USER")
                .requestMatchers("/editHouses/{idHouse}").hasRole("USER")
                .requestMatchers("/deleteHouses/{idHouse}").hasRole("USER")
                .requestMatchers("/available_houses/search_houses").hasRole("USER")

                .requestMatchers("/available_rooms/{idHouse}").hasRole("USER")
                .requestMatchers("/save_rooms/{idHouse}").hasRole("USER")
                .requestMatchers("/rooms_register/{idHouse}").hasRole("USER")
                .requestMatchers("/editRooms/{idHouse}/{idRoom}").hasRole("USER")
                .requestMatchers("/deleteRooms/{idHouse}/{idRoom}").hasRole("USER")
                .requestMatchers("/available_rooms/{idHouse}/search_rooms").hasRole("USER")

                .requestMatchers("/available_facilitys/{idHouse}").hasRole("USER")
                .requestMatchers("/save_facilitys/{idHouse}").hasRole("USER")
                .requestMatchers("/facilitys_register/{idHouse}").hasRole("USER")
                .requestMatchers("/editFacilitys/{idHouse}/{idFacility}").hasRole("USER")
                .requestMatchers("/deleteFacilitys/{idHouse}/{idFacility}").hasRole("USER")
                .requestMatchers("/available_facilitys/{idHouse}/search_facilitys").hasRole("USER")

                .requestMatchers("/available_waterElectricitys/{idHouse}").hasRole("USER")
                .requestMatchers("/save_waterElectricitys/{idHouse}").hasRole("USER")
                .requestMatchers("/waterElectricitys_register/{idHouse}").hasRole("USER")
                .requestMatchers("/editWaterElectricitys/{idHouse}/{idWaterElectricity}").hasRole("USER")
                .requestMatchers("/deleteWaterElectricitys/{idHouse}/{idWaterElectricity}").hasRole("USER")
                .requestMatchers("/available_waterElectricitys/{idHouse}/search_waterElectricitys").hasRole("USER")

                .requestMatchers("/available_tenants/{idHouse}").hasRole("USER")
                .requestMatchers("/save_tenants/{idHouse}").hasRole("USER")
                .requestMatchers("/tenants_register/{idHouse}").hasRole("USER")
                .requestMatchers("/editTenants/{idHouse}/{idTenant}").hasRole("USER")
                .requestMatchers("/deleteTenants/{idHouse}/{idTenant}").hasRole("USER")
                .requestMatchers("/available_tenants/{idHouse}/search_tenants").hasRole("USER")

                .requestMatchers("/available_contracts/{idHouse}").hasRole("USER")
                .requestMatchers("/save_contracts/{idHouse}").hasRole("USER")
                .requestMatchers("/contracts_register/{idHouse}").hasRole("USER")
                .requestMatchers("/editContracts/{idHouse}/{idContract}").hasRole("USER")
                .requestMatchers("/deleteContracts/{idHouse}/{idContract}").hasRole("USER")
                .requestMatchers("/available_contracts/{idHouse}/search_contracts").hasRole("USER")

                .requestMatchers("/available_receipts/{idHouse}").hasRole("USER")
                .requestMatchers("/save_receipts/{idHouse}").hasRole("USER")
                .requestMatchers("/receipts_register/{idHouse}").hasRole("USER")
                .requestMatchers("/editReceipts/{idHouse}/{idReceipt}").hasRole("USER")
                .requestMatchers("/deleteReceipts/{idHouse}/{idReceipt}").hasRole("USER")
                .requestMatchers("/available_receipts/{idHouse}/search_receipts").hasRole("USER")

                .requestMatchers("/available_payments/{idHouse}").hasRole("USER")
                .requestMatchers("/save_payments/{idHouse}").hasRole("USER")
                .requestMatchers("/payments_register/{idHouse}").hasRole("USER")
                .requestMatchers("/editPayments/{idHouse}/{idPayment}").hasRole("USER")
                .requestMatchers("/deletePayments/{idHouse}/{idPayment}").hasRole("USER")
                .requestMatchers("/available_payments/{idHouse}/search_payments").hasRole("USER")
        ).formLogin(
            form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/available_houses")
                //.defaultSuccessUrl("/loginSuccess")
                .permitAll()
        ).logout(
            logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll()
        );
    return http.build();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
  }
}
