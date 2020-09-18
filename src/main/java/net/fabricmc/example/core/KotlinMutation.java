package net.fabricmc.example.core;

import kotlin.reflect.*;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class KotlinMutation<T> implements KMutableProperty0<T> {

    private T t = null;

    public KotlinMutation() {
    }

    public KotlinMutation(T t) {
        this.t = t;
    }


    @Override
    public Setter<T> getSetter() {
        return null;
    }

    @Override
    public void set(T t) {
        this.t = t;
    }

    @Override
    public KProperty0.Getter<T> getGetter() {
        return null;
    }

    @Override
    public T get() {
        return t;
    }


    @Override
    public Object getDelegate() {
        return null;
    }

    @Override
    public T invoke() {
        return t;
    }

    @Override
    public boolean isConst() {
        return false;
    }

    @Override
    public boolean isLateinit() {
        return false;
    }

    @Override
    public boolean isAbstract() {
        return false;
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public boolean isSuspend() {
        return false;
    }


    @Override
    public String getName() {
        return null;
    }


    @Override
    public List<KParameter> getParameters() {
        return null;
    }


    @Override
    public KType getReturnType() {
        return null;
    }

    @Override
    public List<KTypeParameter> getTypeParameters() {
        return null;
    }


    @Override
    public KVisibility getVisibility() {
        return null;
    }

    @Override
    public T call(

            Object... objects) {
        return null;
    }

    @Override
    public T callBy(

            Map<KParameter, ?> map) {
        return null;
    }

 
    @Override
    public List<Annotation> getAnnotations() {
        return null;
    }
}