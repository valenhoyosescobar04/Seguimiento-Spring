package com.example.archivosapi.ArchivoController;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/apiarchivos")
public class ArchivoController {

    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<byte[]> cargarImagen(@PathVariable String nombre) throws IOException {
        Resource imagen = new ClassPathResource("static/imagen/" + nombre + ".jpg");
        byte[] contenido = Files.readAllBytes(imagen.getFile().toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "image/jpg");
        return new ResponseEntity<>(contenido, headers, HttpStatus.OK);
    }

    @GetMapping("/html/{nombre}")
    public ResponseEntity<byte[]> cargarHtml(@PathVariable String nombre) throws IOException {
        Resource html = new ClassPathResource("static/html/" + nombre + ".html");
        byte[] contenido = Files.readAllBytes(html.getFile().toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/html");
        return new ResponseEntity<>(contenido, headers, HttpStatus.OK);
    }

    @GetMapping("/xml/{nombre}")
    public ResponseEntity<byte[]> cargarXml(@PathVariable String nombre) throws IOException {
        Resource xml = new ClassPathResource("static/xml/" + nombre + ".xml");
        byte[] contenido = Files.readAllBytes(xml.getFile().toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/xml");
        return new ResponseEntity<>(contenido, headers, HttpStatus.OK);
    }

    @GetMapping("/pdf/{nombre}")
    public ResponseEntity<byte[]> cargarPdf(@PathVariable String nombre) throws IOException {
        Resource pdf = new ClassPathResource("static/pdf/" + nombre + ".pdf");
        byte[] contenido = Files.readAllBytes(pdf.getFile().toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        return new ResponseEntity<>(contenido, headers, HttpStatus.OK);
    }
}
