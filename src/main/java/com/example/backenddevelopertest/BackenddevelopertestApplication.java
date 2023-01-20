package com.example.backenddevelopertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackenddevelopertestApplication {

    public static String  sPAMKey, sPamURL, sKodePAM, sUserAuth, sPasswordAuth, sPartnerID, sAppId;
	  

	public static void main(String[] args) {
		SpringApplication.run(BackenddevelopertestApplication.class, args);
	}

}
