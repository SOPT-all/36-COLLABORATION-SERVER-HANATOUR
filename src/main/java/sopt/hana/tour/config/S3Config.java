package sopt.hana.tour.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Bean
    public AmazonS3 amazonS3() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                "YOUR_ACCESS_KEY", "YOUR_SECRET_KEY"
        );

        return AmazonS3ClientBuilder.standard()
                .withRegion("ap-southeast-2") // S3 버킷 리전
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
