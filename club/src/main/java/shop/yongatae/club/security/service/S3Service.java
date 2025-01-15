package shop.yongatae.club.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.util.UUID;

@Service
public class S3Service {

  @Value("${aws.s3.bucket-name}")
  private String bucketName;

  private final S3Client s3Client;

  public S3Service(S3Client s3Client) {
    this.s3Client = s3Client;
  }

  public String uploadFile(String key, byte[] content, String mimeType) {
    PutObjectRequest putObjectRequest = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .contentType(mimeType)
        .build();

    s3Client.putObject(putObjectRequest, RequestBody.fromBytes(content));

    return String.format("https://%s.s3.amazonaws.com/%s", bucketName, key);
  }
}