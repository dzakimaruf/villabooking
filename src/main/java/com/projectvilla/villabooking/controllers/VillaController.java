package com.projectvilla.villabooking.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import com.projectvilla.villabooking.model.Villa;
import com.projectvilla.villabooking.services.VillaService;
import com.projectvilla.villabooking.storage.StorageService;
import com.projectvilla.villabooking.storage.UploadFileResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/villa")
public class VillaController {

    @Autowired
    private VillaService villaService;

    @Autowired
    private StorageService storageService;

    @GetMapping
    public ResponseEntity<?> findAllVillat() {
        List<Villa> villas = villaService.findAllVilla();
        return ResponseEntity.ok().body(villas);
    }



    @PostMapping("/add")
    public ResponseEntity<?> addVilla(@RequestBody Villa villa) {

        try {
            Villa vill = villaService.addVilla(villa);

            return ResponseEntity.ok().body(vill);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    } 

    @PostMapping("/addMultipart" )
    public ResponseEntity<?> addProductMultipart(Villa villa, @RequestParam("file") MultipartFile file) {

        try {
            String fileName = storageService.storeFile(file);
            Villa vill = villa;
            if (fileName.contains(".")) {
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/villa/downloadFile/").path(fileName).toUriString();
                        
                vill.setVillImage(fileDownloadUri);
            }
            return ResponseEntity.ok().body(villaService.addVilla(vill));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/findById")
    public ResponseEntity<?> findVillaById(@PathParam("id") Long id) {

        Optional<Villa> Villa = villaService.findVillaById(id);

        if (!Villa.isPresent()) {
            return ResponseEntity.badRequest().body("Data not found");
        }

        return ResponseEntity.ok().body(Villa);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVillaById(@PathVariable("id") Long id) {

        try {
            villaService.deleteVillaById(id);
            return ResponseEntity.ok().body("Record has been deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Record not found");
        }
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = storageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/villa/downloadFile/")
                .path(fileName).toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = storageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
           //
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
    }

}