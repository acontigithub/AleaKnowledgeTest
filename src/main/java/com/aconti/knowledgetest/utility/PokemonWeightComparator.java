package com.aconti.knowledgetest.utility;

import java.util.Comparator;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;

/**
 *
 * @author aconti
 */
public class PokemonWeightComparator implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon a, Pokemon b) {
        return b.getWeight() - a.getWeight();
    }
}
