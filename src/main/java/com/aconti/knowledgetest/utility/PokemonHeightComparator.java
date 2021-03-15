package com.aconti.knowledgetest.utility;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import java.util.Comparator;

/**
 *
 * @author aconti
 */
public class PokemonHeightComparator implements Comparator<Pokemon> {

    @Override
    public int compare(Pokemon a, Pokemon b) {
        return b.getHeight() - a.getHeight();
    }
}
