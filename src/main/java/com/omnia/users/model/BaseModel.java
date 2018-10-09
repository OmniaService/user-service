package com.omnia.users.model;

public class BaseModel<T extends BaseModel<T>> {

    private Long id;

    public Long getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }
}
