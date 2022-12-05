package org.example.view;

public abstract class Viewer<T> {
    private final T model;
    public Viewer(T model) {this.model = model;}
    public T getModel() {return model;}

}
