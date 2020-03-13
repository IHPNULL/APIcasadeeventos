package com.gft.casadeeventos;

import java.util.Locale;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class CasaDeEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaDeEventosApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

//	protected Class<?>[] getRootConfigClasses() {
//		return new Class[] { SecurityConfig.class };
//	}

}
