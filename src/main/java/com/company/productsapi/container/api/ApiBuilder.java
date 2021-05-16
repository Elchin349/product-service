package com.company.productsapi.container.api;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;

public interface ApiBuilder {

    default String timeStamp(){
        return LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    /**
     * Generates ApiError format depending on exception
     * @param ex
     * @return
     */
    default ApiError generateApiError(RuntimeException ex){
        ApiError apiError = new ApiError();
        apiError.setCode(ex.getLocalizedMessage());
        apiError.setDescription(ex.getMessage());
        apiError.setReason(ex.getMessage());
        return apiError;
    }

    default ApiInfo generateApiInfo(RuntimeException ex){
        ApiInfo apiInfo = new ApiInfo();
        apiInfo.setTimestamp(timeStamp());
        apiInfo.setSuccess(false);
        apiInfo.setStatus(ApiConstants.STATUS_FAILED);
        apiInfo.setErrors(Collections.singletonList(generateApiError(ex)));
        return apiInfo;
    }

    default ApiInfo generateApiInfo(){
        ApiInfo apiInfo = new ApiInfo();
        apiInfo.setTimestamp(timeStamp());
        apiInfo.setSuccess(true);
        apiInfo.setStatus(ApiConstants.STATUS_OK);
        return apiInfo;
    }

    default ApiMessage generateApiMessage(){
        ApiMessage apiMessage = new ApiMessage();
        apiMessage.setApiInfo(generateApiInfo());
        return apiMessage;
    }

    default ApiMessage generateApiMessage(ApiInfo apiInfo){
        ApiMessage apiMessage = new ApiMessage();
        apiMessage.setApiInfo(apiInfo);
        return apiMessage;
    }

    default <L extends Serializable> SingleMessage<L> generateSingleMessage(L data){
        SingleMessage<L> singleMessage = new SingleMessage<L>();
        singleMessage.setItem(data);
        singleMessage.setApiInfo(generateApiInfo());
        return singleMessage;
    }


    default <L extends Serializable> CollectionMessage<L> generateCollectionMessage(Collection<L> collection){
       CollectionMessage<L> collectionMessage = new CollectionMessage<L>();
       collectionMessage.setItems(collection);
       collectionMessage.setApiInfo(generateApiInfo());
       return collectionMessage;
    }
}
