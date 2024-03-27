package com.dmanso.apimTestingUtils.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.dmanso.apimTestingUtils.model.Response;

@Service
public class ResponseSizedServiceImpl implements ResponseSizedService{

    @Override
    public Response getSizedResponse(int sizeInBytes) {
        return new Response(sizeInBytes, getRandomBase64String(sizeInBytes));
    }
    
    private String getRandomBase64String(int sizeInBytes){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        if(sizeInBytes>95){
            sizeInBytes = sizeInBytes -94;
        }
        return random.ints(leftLimit, rightLimit + 1)
            .limit(sizeInBytes)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

    }


}
