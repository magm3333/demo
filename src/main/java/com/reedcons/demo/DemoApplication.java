package com.reedcons.demo;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.reedcons.demo.business.impl.util.fs.ArchivoFSProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	ArchivoFSProperties.class
})
public class DemoApplication implements CommandLineRunner {
	
	private Logger log=LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ArchivoFSProperties archivoFSProperties;
	
	//error
	//warning 
	//info 
	//debug 
	//trace <==
	
	@Override
	public void run(String... args) throws Exception {
		log.trace("DataSource={}",dataSource);
		log.debug("Los archivos se subirán a: {}",archivoFSProperties.getDirectorioAlmacenamiento());
		
	}
}
