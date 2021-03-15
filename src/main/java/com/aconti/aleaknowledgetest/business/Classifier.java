package com.aconti.aleaknowledgetest.business;

import com.aconti.aleaknowledgetest.exception.CollectionIsTooSmallException;
import com.aconti.knowledgetest.utility.PokemonWeightComparator;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.utils.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author aconti
 */
public class Classifier {
    public String[] getBest5(Comparator<Pokemon> comparator) throws CollectionIsTooSmallException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Gson gson = getGson();
        List<Pokemon> all = getNewArrayList();

        NamedAPIResourceList list = getPokemonList(151, 0);
        int lastId = list.getResults().size();
        int id = 1;
        while (id < lastId) {
            Pokemon pokemon = getPokemonById(id);
            all.add(pokemon);
            id++;
        }
        if (all.size() < 5) {
            throw new CollectionIsTooSmallException();
        }
        all = purgeNonRedPokemon(all);
        Collections.sort(all, comparator);
        String[] output = getNewStringArray();
        output[0] = gson.toJson(all.get(0));
        output[1] = gson.toJson(all.get(1));
        output[2] = gson.toJson(all.get(2));
        output[3] = gson.toJson(all.get(3));
        output[4] = gson.toJson(all.get(4));
        return output;
    }
    protected NamedAPIResourceList getPokemonList(int limit, int offset){
        return Client.getPokemonList(limit, offset);
    }
    
    protected Pokemon getPokemonById(int id){
        return Client.getPokemonById(id);
    }

    protected Gson getGson() {
        return getGsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
    }

    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }

    protected List<Pokemon> getNewArrayList() {
        return new ArrayList<>();
    }

    protected PokemonWeightComparator getPokemonWeightComparator() {
        return new PokemonWeightComparator();
    }

    protected String[] getNewStringArray() {
        return new String[5];
    }

    protected List<Pokemon> purgeNonRedPokemon(List<Pokemon> all) {
        return all.stream().filter(p->p.getGameIndices().get(0).getVersion().getName().equals("red")).collect(Collectors.toList());
    }
}
