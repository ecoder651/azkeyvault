package com.cg.keyvault.azkeyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AzkeyvaultApplication implements CommandLineRunner {
	
	@Value("${sampleProperty1}")
    private String sampleProperty1;
    @Value("${sampleProperty2}")
    private String sampleProperty2;
    @Value("${samplePropertyInMultipleKeyVault}")
    private String samplePropertyInMultipleKeyVault;
    
    @Value("${dbname}")
    private String dbname;
    @Value("${host}")
    private String host;
    @Value("${port}")
    private String port;

	public static void main(String[] args) {
		SpringApplication.run(AzkeyvaultApplication.class, args);
	}
	
	public void run(String[] args) {
        System.out.println("sampleProperty1: " + sampleProperty1);
        System.out.println("sampleProperty2: " + sampleProperty2);
        System.out.println("samplePropertyInMultipleKeyVault: " + samplePropertyInMultipleKeyVault);
        
        System.out.println("Database : " + host + ":" + port + "/" + dbname);
    }

}
