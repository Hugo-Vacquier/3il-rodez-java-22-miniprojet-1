package fr.ecole3il.rodez2023.perlin.exceptions;

public class MauvaiseValeurException extends IllegalArgumentException {
    public MauvaiseValeurException(String errorMessage) {
        super(errorMessage);
    }
}
