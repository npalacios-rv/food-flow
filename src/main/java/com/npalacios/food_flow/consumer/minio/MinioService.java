package com.npalacios.food_flow.consumer.minio;

import io.minio.*;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class MinioService {

    private final MinioClient minioClient;
    private final MinioProperties minioProperties;

    public String uploadBase64Image(String base64Image, String fileName, String contentType) {
        try {
            // Eliminar prefijo si viene con "data:image/png;base64,..."
            String base64Data = base64Image.contains(",")
                    ? base64Image.split(",")[1]
                    : base64Image;

            byte[] imageBytes = Base64.getDecoder().decode(base64Data);
            InputStream inputStream = new ByteArrayInputStream(imageBytes);

            // Asegurarse de que el bucket existe
            ensureBucketExists();

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(minioProperties.getBucketName())
                            .object(fileName)
                            .stream(inputStream, imageBytes.length, -1)
                            .contentType(contentType)
                            .build()
            );

            log.info("Archivo subido exitosamente: {}", fileName);
            return fileName;

        } catch (Exception e) {
            log.error("Error al subir archivo a MinIO: {}", e.getMessage());
            throw new RuntimeException("Error al subir imagen a MinIO", e);
        }
    }

    private void ensureBucketExists() throws Exception {
        boolean exists = minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(minioProperties.getBucketName())
                        .build()
        );
        if (!exists) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(minioProperties.getBucketName())
                            .build()
            );
            log.info("Bucket creado: {}", minioProperties.getBucketName());
        }
    }

    public String getPresignedUrl(String fileName) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(minioProperties.getBucketName())
                            .object(fileName)
                            .method(Method.GET)
                            .expiry(minioProperties.getExpiryHours(), TimeUnit.HOURS)
                            .build()
            );
        } catch (Exception e) {
            log.error("Error al generar URL presignada: {}", e.getMessage());
            throw new RuntimeException("Error al obtener URL del archivo", e);
        }
    }
}
