package com.company.productsapi.container.api;

import java.io.Serializable;


public class ApiError implements Serializable {
    private static final long serialVersionUID = 1780375174864761641L;
    private String code;
    private String reason;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "code='" + code + '\'' +
                ", reason='" + reason + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public ApiError() {
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiError)) {
            return false;
        } else {
            ApiError other = (ApiError) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$code = this.getCode();
                    Object other$code = this.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$reason = this.getReason();
                Object other$reason = this.getReason();
                if (this$reason != null) {
                    if (other$reason != null) {
                        return false;
                    }
                } else if (!this$reason.equals(other$reason)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = this.getDescription();
                if (this$description != null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                return true;
            }
        }
    }

    private boolean canEqual(Object other) {
        return other instanceof ApiError;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $reason = this.getReason();
        result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        return result;
    }
}
