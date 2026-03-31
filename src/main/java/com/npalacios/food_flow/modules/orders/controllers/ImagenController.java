package com.npalacios.food_flow.modules.orders.controllers;

import com.npalacios.food_flow.consumer.minio.ImagenRequest;
import com.npalacios.food_flow.consumer.minio.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders/images")
@RequiredArgsConstructor
public class ImagenController {

    private final MinioService minioService;

    @PostMapping("/subir")
    public ResponseEntity<Map<String, String>> subirImagen(@RequestBody ImagenRequest request) {
        // Generar nombre único para el archivo
        String fileName = "imagenes/" + UUID.randomUUID() + ".png";

        // Subir a MinIO
        minioService.uploadBase64Image(request.getBase64(), fileName, "image/png");

        // Obtener URL de acceso
        String url = minioService.getPresignedUrl(fileName);

        return ResponseEntity.ok(Map.of(
                "fileName", fileName,
                "url", url
        ));
    }
}
