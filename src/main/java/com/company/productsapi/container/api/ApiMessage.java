package com.company.productsapi.container.api;



import java.io.Serializable;


public class ApiMessage implements Serializable {
    private static final long serialVersionUID = -3357088028681030590L;

    private ApiInfo apiInfo;

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    @Override
    public String toString() {
        return "ApiMessage{" +
                "apiInfo=" + apiInfo +
                '}';
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiMessage)) {
            return false;
        } else {
            ApiMessage other = (ApiMessage) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$info = this.getApiInfo();
                Object other$info = this.getApiInfo();
                if (this$info != null) {
                    if (other$info != null) {
                        return false;
                    }
                } else if (!this$info.equals(other$info)) {
                    return false;
                }

                return true;
            }
        }
    }

    private boolean canEqual(Object other) {
        return other instanceof ApiMessage;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $info = this.getApiInfo();
        result = result * 59 + ($info == null ? 43 : $info.hashCode());
        return result;
    }
}
