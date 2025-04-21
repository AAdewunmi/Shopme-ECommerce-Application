package com.shopme.admin;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;*/

public class AmazonS3Util {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonS3Util.class);
	private static final String BUCKET_NAME;
	
	static {
		BUCKET_NAME = System.getenv("AWS_BUCKET_NAME");
	}
	
	
	/*
	 * public static List<String> listFolder(String folderName) { S3Client client =
	 * S3Client.builder().build(); ListObjectsRequest listRequest =
	 * ListObjectsRequest.builder() .bucket(BUCKET_NAME).prefix(folderName).build();
	 * 
	 * ListObjectsResponse response = client.listObjects(listRequest);
	 * 
	 * List<S3Object> contents = response.contents();
	 * 
	 * ListIterator<S3Object> listIterator = contents.listIterator();
	 * 
	 * List<String> listKeys = new ArrayList<>();
	 * 
	 * while (listIterator.hasNext()) { S3Object object = listIterator.next();
	 * listKeys.add(object.key()); }
	 * 
	 * return listKeys; }
	 */
	 
}
