package com.company.productsapi.container.api;


import java.io.Serializable;
import java.util.Collection;

public class CollectionMessage <D extends Serializable> extends ApiMessage implements Serializable {
    private static final long serialVersionUID = 8335801184181144754L;
    private Collection<D> items;

    public Collection<D> getItems() {
        return items;
    }

    public void setItems(Collection<D> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CollectionMessage{" +
                "items=" + items +
                '}';
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CollectionMessage)) {
            return false;
        } else {
            CollectionMessage<?> other = (CollectionMessage) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$items = this.getItems();
                Object other$items = this.getItems();
                if (this$items != null) {
                    if (other$items != null) {
                        return false;
                    }
                } else if (!this$items.equals(other$items)) {
                    return false;
                }

                return true;
            }
        }
    }

    private boolean canEqual(Object other) {
        return other instanceof CollectionMessage;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        return result;
    }
}
