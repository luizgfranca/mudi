package com.study.mudi.dto;

import com.study.mudi.model.Request;
import lombok.Data;

@Data
public class NewRequestDto {

    private String productName;
    private String productUrl;
    private String imageUrl;
    private String description;

    public Request toRequest() {

        var request = new Request();
        request.setName(productName);
        request.setDescription(description);
        request.setImgUrl(imageUrl);
        request.setProductUrl(productUrl);

        return request;

    }
}
