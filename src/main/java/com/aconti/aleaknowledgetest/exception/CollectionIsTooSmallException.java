package com.aconti.aleaknowledgetest.exception;

/**
 *
 * @author aconti
 */
public class CollectionIsTooSmallException extends Exception {
    public CollectionIsTooSmallException(){
        super("There are not at least 5 pokemons to show");
    }
}
