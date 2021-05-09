package com.study.mudi.dto;

import com.study.mudi.model.Request;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NewRequestDto {

    @NotBlank //notblank.NewRequestDto.productName
    private String productName;

    @NotBlank
    private String productUrl;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String description;

    @NotBlank
    public Request toRequest() {

        var request = new Request();
        request.setName(productName);
        request.setDescription(description);
        request.setImgUrl(imageUrl);
        request.setProductUrl(productUrl);

        return request;

    }
}
