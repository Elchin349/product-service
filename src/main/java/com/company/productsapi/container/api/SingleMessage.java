package com.company.productsapi.container.api;


import java.io.Serializable;


public class SingleMessage  <D extends Serializable> extends ApiMessage implements Serializable{
    private static final long serialVersionUID = -1432434062401274507L;
    private D item;

    public D getItem() {
        return item;
    }

    public void setItem(D item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "SingleMessage{" +
                "item=" + item +
                '}';
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SingleMessage)) {
            return false;
        } else {
            SingleMessage<?> other = (SingleMessage) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$item = this.getItem();
                Object other$item = this.getItem();
                if (this$item != null) {
                    if (other$item != null) {
                        return false;
                    }
                } else if (!this$item.equals(other$item)) {
                    return false;
                }

                return true;
            }
        }
    }

    private boolean canEqual(Object other) {
        return other instanceof SingleMessage;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $item = this.getItem();
        result = result * 59 + ($item == null ? 43 : $item.hashCode());
        return result;
    }
}
