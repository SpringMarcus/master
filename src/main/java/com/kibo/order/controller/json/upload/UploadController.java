package com.kibo.order.controller.json.upload;

import com.kibo.order.controller.json.upload.response.UploadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Controller marks the class as a web controller, capable of handling the HTTP requests.
 * Spring will look at the methods of the class marked with the @Controller annotation and
 * establish the routing table to know which methods serve which endpoints.
 * @RequestMapping(value = “/path”) annotation specifies a method
 * in the controller that should be responsible for serving the HTTP request to the given path.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    /**
     * @ResponseBody is a utility annotation that makes Spring bind a method’s return value
     * to the HTTP response body. When building a JSON endpoint, this is an amazing way
     * to magically convert your objects into JSON for easier consumption.
     * @ResponseStatus(HttpStatus.OK) specifies the HTTP status when method successfully returns
     * @RequestMapping(method = RequestMethod.GET, value = “/path”) annotation specifies a method
     * in the controller that should be responsible for serving the HTTP request to the given path.
     * @param file
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UploadResponse giftCertificateUpload(@RequestParam("file") MultipartFile file) throws Exception {

        UploadResponse response = new UploadResponse();

        try {

            File realFile = File.createTempFile("giftCertificateUpload", "csv");
            realFile.deleteOnExit();
            file.transferTo(realFile);

            String fileName = file.getOriginalFilename();

            response.setFileName(fileName);
            response.setSuccess(true);

        } catch(IOException e) {
            response.setSuccess(false);
        }

        return response;
    }
}
