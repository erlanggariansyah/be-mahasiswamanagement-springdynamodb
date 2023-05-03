package com.erlanggariansyah.mahasiswamanagementspringdynamodb.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.erlanggariansyah.mahasiswamanagementspringdynamodb.repository")
public class DynamoDBConfig {
    @Value(value = "${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value(value = "${amazon.aws.accesskey}")
    private String amazonAWSAccesKey;

    @Value(value = "${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(awsCredentials());
        if (!amazonDynamoDBEndpoint.isEmpty()) amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials awsCredentials() {
        return new BasicAWSCredentials(amazonAWSAccesKey, amazonAWSSecretKey);
    }
}
