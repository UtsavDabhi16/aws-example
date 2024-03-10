package com.example.awsexample;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class Coco {
    public static void main(String[] args) {
        // Replace these values with your AWS access key and secret key
        String accessKey = "";
        String secretKey = "";

        // Set AWS region
        String region = "us-east-1";

        // Create credentials object
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        // Create Amazon S3 client
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();

        // List buckets
        System.out.println("List of S3 buckets:");
        for (Bucket bucket : s3Client.listBuckets()) {
            System.out.println(bucket.getName());
        }
    }
}
