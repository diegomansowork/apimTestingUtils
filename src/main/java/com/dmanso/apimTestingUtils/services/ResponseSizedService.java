package com.dmanso.apimTestingUtils.services;

import com.dmanso.apimTestingUtils.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ResponseSizedService {
    
    public Response getSizedResponse(int sizeInBytes);

}
