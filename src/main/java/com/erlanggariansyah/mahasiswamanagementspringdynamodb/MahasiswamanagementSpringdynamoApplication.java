package com.erlanggariansyah.mahasiswamanagementspringdynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.model.Mahasiswa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MahasiswamanagementSpringdynamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MahasiswamanagementSpringdynamoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AmazonDynamoDB amazonDynamoDB) {
		return args -> {
//			DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//			CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(Mahasiswa.class);
//			createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//
//			amazonDynamoDB.createTable(createTableRequest);
		};
	}
}
