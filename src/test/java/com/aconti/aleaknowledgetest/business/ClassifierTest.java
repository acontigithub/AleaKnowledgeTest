package com.aconti.aleaknowledgetest.business;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import com.aconti.aleaknowledgetest.exception.CollectionIsTooSmallException;
import com.aconti.knowledgetest.utility.PokemonBaseExperienceComparator;
import com.aconti.knowledgetest.utility.PokemonHeightComparator;
import com.aconti.knowledgetest.utility.PokemonWeightComparator;
import static org.mockito.ArgumentMatchers.anyInt;
/**
 *
 * @author aconti
 */
public class ClassifierTest {
    @Test
    public void getNewArrayList() {
        //definition
        Classifier classifier = new Classifier();
        //definition
        
        //do
        List<Pokemon> result = classifier.getNewArrayList();
        //do

        //assert verify
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).isEmpty();
        //assert verify
    }
    
    @Test
    public void getNewStringArray() {
        //definition
        Classifier classifier = new Classifier();
        //definition
        
        //do
        String[] result = classifier.getNewStringArray();
        //do

        //assert verify
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).hasSize(5);
        //assert verify
    }
    
    @Test
    public void get5Pokemons_when_list_hold_less_than_5_items() {
        //definition
        Classifier classifier = new Classifier();
        Classifier classifierSpy = Mockito.spy(classifier);
        NamedAPIResourceList namedAPIResourceListMock = Mockito.mock(NamedAPIResourceList.class);
        ArrayList<NamedAPIResource> results = Mockito.mock(ArrayList.class);
        List<Pokemon> all = Mockito.mock(List.class);
        PokemonBaseExperienceComparator comparator = new PokemonBaseExperienceComparator();
        //definition
        
        //stubbing
        Mockito.doReturn(all).when(classifierSpy).getNewArrayList();
        Mockito.doReturn(namedAPIResourceListMock).when(classifierSpy).getPokemonList(151, 0);
        Mockito.doReturn(results).when(namedAPIResourceListMock).getResults();
        Mockito.doReturn(4).when(results).size();
        //stubbing
        
        //do
        Assertions.assertThatExceptionOfType(CollectionIsTooSmallException.class)
                .isThrownBy(() -> classifierSpy.getBest5(comparator))
                .withMessage("There are not at least 5 pokemons to show");
        //do

        //assert verify
        Mockito.verify(classifierSpy, times(1)).getGson();
        Mockito.verify(classifierSpy, times(1)).getNewArrayList();
        Mockito.verify(classifierSpy, times(1)).getPokemonList(151, 0);
        Mockito.verify(namedAPIResourceListMock, times(1)).getResults();
        Mockito.verify(classifierSpy, times(3)).getPokemonById(anyInt());
        Mockito.verify(all, times(3)).add(any());
        Mockito.verify(all, times(1)).size();
        //assert verify
    }
    
    @Test
    public void get5BaseExperiencePokemons() throws ClassNotFoundException, CollectionIsTooSmallException {
        //definition
        Classifier classifier = new Classifier();
        PokemonBaseExperienceComparator comparator = new PokemonBaseExperienceComparator();
        //definition
        
        //stubbing
        //stubbing
        
        //do
        String[] result = classifier.getBest5(comparator);
        //do
        
        Pokemon pokemon0 = classifier.getGson().fromJson(result[0], Pokemon.class);
        Pokemon pokemon1 = classifier.getGson().fromJson(result[1], Pokemon.class);
        Pokemon pokemon2 = classifier.getGson().fromJson(result[2], Pokemon.class);
        Pokemon pokemon3 = classifier.getGson().fromJson(result[3], Pokemon.class);
        Pokemon pokemon4 = classifier.getGson().fromJson(result[4], Pokemon.class);

        //assert verify
        Assertions.assertThat(pokemon0.getId()).isEqualTo(113);
        Assertions.assertThat(pokemon0.getBaseExperience()).isEqualTo(395);
        Assertions.assertThat(pokemon0.getName()).isEqualTo("chansey");
        
        Assertions.assertThat(pokemon1.getId()).isEqualTo(150);
        Assertions.assertThat(pokemon1.getBaseExperience()).isEqualTo(306);
        Assertions.assertThat(pokemon1.getName()).isEqualTo("mewtwo");
        
        Assertions.assertThat(pokemon2.getId()).isEqualTo(149);
        Assertions.assertThat(pokemon2.getBaseExperience()).isEqualTo(270);
        Assertions.assertThat(pokemon2.getName()).isEqualTo("dragonite");
        
        Assertions.assertThat(pokemon3.getId()).isEqualTo(144);
        Assertions.assertThat(pokemon3.getBaseExperience()).isEqualTo(261);
        Assertions.assertThat(pokemon3.getName()).isEqualTo("articuno");
        
        Assertions.assertThat(pokemon4.getId()).isEqualTo(145);
        Assertions.assertThat(pokemon4.getBaseExperience()).isEqualTo(261);
        Assertions.assertThat(pokemon4.getName()).isEqualTo("zapdos");
        //assert verify
    }
    
    @Test
    public void get5HeightPokemons() throws ClassNotFoundException, CollectionIsTooSmallException {
        //definition
        Classifier classifier = new Classifier();
        PokemonHeightComparator comparator = new PokemonHeightComparator();
        //definition
        
        //stubbing
        //stubbing
        
        //do
        String[] result = classifier.getBest5(comparator);
        //do
        
        Pokemon pokemon0 = classifier.getGson().fromJson(result[0], Pokemon.class);
        Pokemon pokemon1 = classifier.getGson().fromJson(result[1], Pokemon.class);
        Pokemon pokemon2 = classifier.getGson().fromJson(result[2], Pokemon.class);
        Pokemon pokemon3 = classifier.getGson().fromJson(result[3], Pokemon.class);
        Pokemon pokemon4 = classifier.getGson().fromJson(result[4], Pokemon.class);

        //assert verify
        Assertions.assertThat(pokemon0.getId()).isEqualTo(95);
        Assertions.assertThat(pokemon0.getHeight()).isEqualTo(88);
        Assertions.assertThat(pokemon0.getName()).isEqualTo("onix");
        
        Assertions.assertThat(pokemon1.getId()).isEqualTo(130);
        Assertions.assertThat(pokemon1.getHeight()).isEqualTo(65);
        Assertions.assertThat(pokemon1.getName()).isEqualTo("gyarados");
        
        Assertions.assertThat(pokemon2.getId()).isEqualTo(148);
        Assertions.assertThat(pokemon2.getHeight()).isEqualTo(40);
        Assertions.assertThat(pokemon2.getName()).isEqualTo("dragonair");
        
        Assertions.assertThat(pokemon3.getId()).isEqualTo(24);
        Assertions.assertThat(pokemon3.getHeight()).isEqualTo(35);
        Assertions.assertThat(pokemon3.getName()).isEqualTo("arbok");
        
        Assertions.assertThat(pokemon4.getId()).isEqualTo(131);
        Assertions.assertThat(pokemon4.getHeight()).isEqualTo(25);
        Assertions.assertThat(pokemon4.getName()).isEqualTo("lapras");
        //assert verify
    }
    
    @Test
    public void get5WeightPokemons() throws ClassNotFoundException, CollectionIsTooSmallException {
        //definition
        Classifier classifier= new Classifier();
        PokemonWeightComparator comparator = new PokemonWeightComparator();
        //definition
        
        //stubbing
        //stubbing
        
        //do
        String[] result = classifier.getBest5(comparator);
        //do
        
        Pokemon pokemon0 = classifier.getGson().fromJson(result[0], Pokemon.class);
        Pokemon pokemon1 = classifier.getGson().fromJson(result[1], Pokemon.class);
        Pokemon pokemon2 = classifier.getGson().fromJson(result[2], Pokemon.class);
        Pokemon pokemon3 = classifier.getGson().fromJson(result[3], Pokemon.class);
        Pokemon pokemon4 = classifier.getGson().fromJson(result[4], Pokemon.class);

        //assert verify
        Assertions.assertThat(pokemon0.getId()).isEqualTo(143);
        Assertions.assertThat(pokemon0.getWeight()).isEqualTo(4600);
        Assertions.assertThat(pokemon0.getName()).isEqualTo("snorlax");
        
        Assertions.assertThat(pokemon1.getId()).isEqualTo(76);
        Assertions.assertThat(pokemon1.getWeight()).isEqualTo(3000);
        Assertions.assertThat(pokemon1.getName()).isEqualTo("golem");
        
        Assertions.assertThat(pokemon2.getId()).isEqualTo(130);
        Assertions.assertThat(pokemon2.getWeight()).isEqualTo(2350);
        Assertions.assertThat(pokemon2.getName()).isEqualTo("gyarados");
        
        Assertions.assertThat(pokemon3.getId()).isEqualTo(131);
        Assertions.assertThat(pokemon3.getWeight()).isEqualTo(2200);
        Assertions.assertThat(pokemon3.getName()).isEqualTo("lapras");
        
        Assertions.assertThat(pokemon4.getId()).isEqualTo(95);
        Assertions.assertThat(pokemon4.getWeight()).isEqualTo(2100);
        Assertions.assertThat(pokemon4.getName()).isEqualTo("onix");
        //assert verify
    }
    

}
