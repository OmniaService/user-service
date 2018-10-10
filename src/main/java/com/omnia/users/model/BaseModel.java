package com.omnia.users.model;

public abstract class BaseModel<T extends BaseModel<T>> {

    private Long id;

    public BaseModel() {
    }

    public Long getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public abstract String toString();
}
