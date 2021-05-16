package com.company.productsapi.container.api;


import java.io.Serializable;
import java.util.Collection;

public class ApiInfo implements Serializable {

    private static final long serialVersionUID = -6653742194514935840L;
    private boolean success;
    private String status;
    private String requestId;
    private String responseId;
    private String timestamp;
    private Collection<ApiError> errors;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Collection<ApiError> getErrors() {
        return errors;
    }

    public void setErrors(Collection<ApiError> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ApiInfo{" +
                "success=" + success +
                ", status='" + status + '\'' +
                ", requestId='" + requestId + '\'' +
                ", responseId='" + responseId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", errors=" + errors +
                '}';
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiInfo)) {
            return false;
        } else {
            ApiInfo other = (ApiInfo) o;
            if (!other.canEqual(this)) {
                return false;
            }
            else if(this.isSuccess() != other.isSuccess()){
                return false;
            }
            else {
                label73:
                {
                    Object this$status = this.getStatus();
                    Object other$status = this.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label73;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label73;
                    }

                    return false;
                }

                Object this$requestId = this.getRequestId();
                Object other$requestId = this.getRequestId();
                if (this$requestId != null) {
                    if (other$requestId != null) {
                        return false;
                    }
                } else if (!this$requestId.equals(other$requestId)) {
                    return false;
                }

                label59:{
                    Object this$responseId = this.getResponseId();
                    Object other$responseId = this.getResponseId();
                    if (this$responseId == null) {
                        if (other$responseId == null) {
                            break label59;
                        }
                    } else if (this$responseId.equals(other$responseId)) {
                        break label59;
                    }

                    return false;
                }

                Object this$timestamp = this.getTimestamp();
                Object other$timestamp = this.getTimestamp();
                if (this$timestamp != null) {
                    if (other$timestamp != null) {
                        return false;
                    }
                } else if (!this$timestamp.equals(other$timestamp)) {
                    return false;
                }

                Object this$errors= this.getErrors();
                Object other$errors = this.getErrors();
                if (this$errors != null) {
                    if (other$errors != null) {
                        return false;
                    }
                } else if (!this$errors.equals(other$errors)) {
                    return false;
                }

                return true;
            }
        }
    }

    private boolean canEqual(Object other) {
        return other instanceof ApiInfo;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $requestId = this.getRequestId();
        result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
        Object $responseId = this.getResponseId();
        result = result * 59 + ($responseId == null ? 43 : $responseId.hashCode());
        Object $timestamp = this.getTimestamp();
        result = result * 59 + ($timestamp == null ? 43 : $timestamp.hashCode());
        Object $errors = this.getErrors();
        result = result * 59 + ($errors == null ? 43 : $errors.hashCode());
        return result;
    }
}
