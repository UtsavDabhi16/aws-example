package com.example.awsexample;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class S3Service {
    @Value("${aws.s3.bucket.name}")
    private String bucketName;
    private final AmazonS3 s3Client;
    @Autowired
    public S3Service(AmazonS3 s3Client) {
        this.s3Client=s3Client;
    }
    public List<String> listObjects() {
        ObjectListing objectListing=s3Client.listObjects(bucketName);
        return objectListing.getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }
}
