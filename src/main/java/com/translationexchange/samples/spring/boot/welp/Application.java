package com.translationexchange.samples.spring.boot.welp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.translationexchange.core.Tml;
import com.translationexchange.core.Utils;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

    public static void main(String[] args) throws Exception {
    	Tml.getConfig().setApplication(Utils.buildMap(
			"key", "df43596aab7bf9a9981289d2ded0732ad2bd358e2f79af65239b2280d52f0566",	
			"host", "http://localhost:3000",
			"cdn_host", "https://trex-snapshots-dev.s3-us-west-1.amazonaws.com"
		));
		
		Tml.getConfig().setAgent(Utils.buildMap(
			"host", "http://localhost:8282/dist/agent.js"
		));
	
		Tml.getConfig().setCache(Utils.buildMap(
			"enabled", 				true,	
	    	"class", 				"com.translationexchange.cache.Memcached",
	        "host", 				"localhost:11211",
	        "namespace", 			"df43596aab7bf9a9981289d2ded0732ad2bd358e2f79af65239b2280d52f0566",
	        "version_check_interval", 10
		));	
    	
        SpringApplication.run(Application.class, args);
    }

}