package com.addjve.pasteapp.controller;

import com.addjve.pasteapp.dto.PasteLockerRequest;
import com.addjve.pasteapp.dto.PasteLockerResponse;
import com.addjve.pasteapp.dto.PasteLockerUrlResponse;
import com.addjve.pasteapp.services.PasteLockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasteLockerController {
    private final PasteLockerService service;

    @GetMapping("/")
    public List<PasteLockerResponse> getPublicPasteList(){
        return service.getFirstPublicPasteLocker();
    }

    @GetMapping("/{hash}")
    public PasteLockerResponse getByHash(@PathVariable String hash){
        return service.getByHash(hash);
    }

    @PostMapping("/")
    public PasteLockerUrlResponse add(@RequestBody PasteLockerRequest request) {
       return service.addPasteLocker(request);
    }

}
