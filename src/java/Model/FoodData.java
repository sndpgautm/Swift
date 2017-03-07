/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Rocke
 */
public class FoodData {

    private static final ArrayList<Food> menu = new ArrayList<Food>();

    public FoodData() {
        menu.add(new Food("SAG AALU(G,L)", "Pinaattia ja keitettyä perunaa mausteisessa tomaatti-valkosipuli-inkiväärikastikkeessa.\n"
                + "Spinach and boiled potatoes in spicy tomato-garlic-ginger sauce.", 13.00));
        menu.add(new Food("TOFU MASALA (G, L)", "Tofua ja paprika tomaatti-sipuli- chili ja soija kastikkeessa.\n"
                + "Tofu and capsicum in tomato- onion- chili & soya sauce.", 13.00));
        menu.add(new Food("SABJEE KORMA (G)", "Kasvismuhennosta kermakastikkeessa. Sisältää kukkakaalia, parsakaali, paprikaa, vihreitäpapuja, herneitä, tuorejuustoa ja rusinoita.\n"
                + "Mixed vegetables stew consisting of cauliflower, broccoli, capsicum, green beans, sweet peasand cottage cheese and raisins in cream sauce.", 13.50));
        menu.add(new Food("MALAHI KOFTA (G)", "Cashewpähkinä-peruna-tuorejuustopyöryköitä tomaatti-voi-kermakastikkeessa.\n"
                + "Mashed potatoes, cottage cheese and cashew nut balls in smooth and mellow tomato-butter-cream sauce.", 14.00));
        menu.add(new Food("PANEER MASALA (G)", "Paistettua tuorejuustoa ja paprikaa hieman tulisessa tomaatti-chili-valkosipuli-inkiväärikastikkeessa.\n"
                + "Fried cottage cheese and capsicum in slightly spicy tomato-chilli-garlic-ginger sauce.", 14.50));
        menu.add(new Food("KUKHURAKO MASU (G, L)", "Haudutettuja kanafileepaloja tomaatti-sipuli-currykastikkeessa.\n"
                + "Stewed chicken fillet pieces in tomato-onion-curry sauce.", 13.50));
        menu.add(new Food("KUKHURA CHILLI (G, L)", "Linssijauholla kuorrutettuja ja friteerattuja kanafileepaloja, paprikaa ja chiliä paksussa mausteisessa valkosipuli-sipuli-inkivääri-tomaatikastikkeessa.\n"
                + "Deep fried chicken fillet- pieces coated with gram batter; and capsicum and chilies in thick hot spicy garlic-onion-ginger-tomato sauce.", 15.50));
        menu.add(new Food("KUKHURA KORMA (G)", "Haudutettuja kanafileepaloja curry-kerma-cashew-cokos pähkinäkastikkeessa.\n"
                + "Fine pieces of stewed chicken fillet in curry-cream-cashew-coconut sauce.", 15.90));
        menu.add(new Food("KUKHURA SAG KARAHI (G)", "Haudutettuja kanafileepaloja ja tuoretta tomaattia pinaatti-inkivääri-kookos-kermakastikkeessa.\n"
                + "Stewed chicken fillet pieces and fresh tomatoes in spinach-ginger-coconut-cream sauce.", 15.90));
        menu.add(new Food("KUKHURA TIKKA MASALA (G)", "Yrtti-jogurttimarinoituja ja tandoori-uunissa grillattuja kanafileepaloja tulisessa ja mausteisessa tomaattisipuli-valkosipuli-inkivääri-chili-masalakastikkeessa.\n"
                + "Tandoori-grilled herb-yoghurt marinated chicken fillet pieces in hot & spicy tomato-onion-garlic-ginger-chilli–masala sauce.", 16.00));
        menu.add(new Food("PANEER KUKHURA MASALA (G)", "Yrtti-jogurttimarinoituja, tandoorissa paistettuja kanan rintapaloja ja tuoreuustoa paprika-tomaatti-masalakastikessa.\n"
                + "Herb and yoghurt marinated tandoori- grilled chicken fillet pieces and cottage cheese with capsicum in tomato-masala sauce.", 16.50));
        menu.add(new Food("KUKHURAKO CHHOILA (G)", "Yrtti-jogurttimarinoituja ja tandoori-uunissa grillattuja kanafileeviipaleita sekä paistettuja soijapapuja. Maustettu tomaatilla, vihreällä chilillä, rohtosarviapilan siemenillä, kuminan siemenillä, inkiväärillä, valkosipulilla, korianterilla, sinappiöljyllä ja sitruunalla.\n"
                + "Herb and yoghurt marinated tandoori-oven grilled chicken fillet slices; and soaked and friedsoya beans seasoned with tomato, green chili, fenugreek seeds, cumin seeds, chopped ginger, garlic, coriander, mustard oil and lemon juice.\n"
                + "", 17.90));
        menu.add(new Food("KHASIKO MASU (G, L)", "Haudutettuja lampaanpaloja tomaatti-sipuli-currykastikkeessa.\n"
                + "Stewed lamb pieces in tomato-onion-curry sauce.", 14.90));
        menu.add(new Food("KHASI LASUNE SAG (G, L)", "Haudutettuja lampaanpaloja pinaatti-valkosipuli-inkiväärikastikkeessa.\n"
                + "Stewed lamb in spinach-garlic-ginger-tomato sauce.", 15.50));
        menu.add(new Food("PIRO KHASI (G, L)", "Ruskistettua paprikaa ja chiliä ja haudutettuja lampaanpaloja hyvin tulisessa ja mausteisessa sipuli-valkosipuli-tomaattikastikkeessa.\n"
                + "Sautéed capsicum and chillies, and stewed lamb pieces in very hot & spicy onion-garlic-tomato sauce.", 16.00));
        menu.add(new Food("KHASI TIKKA MASALA (G)", "Yrtti-jogurttimarinoituja ja tandoori-uunissa grillattuja lampaan sisäfileepaloja tulisessa ja mausteisessa tomaatti-sipuli-valkosipuli-inkivääri-chili-masalakastikkeessa.\n"
                + "Tandoori-grilled herb-yoghurt marinated lamb tenderloin pieces in hot & spicy tomato-onion-garlic-ginger-chill-masala sauce.", 16.50));
        menu.add(new Food("KHASI SEKUWA (G)", "Yrtti-jogurttimarinoituja ja tandoori-uunissa grillattuja lampaan sisäfileepaloja hieman maustetun ja ruskistetun paprikan, tomaatin ja sipulin kera.\n"
                + "Herb and yoghurt marinated, tandoori-oven grilled lamb tenderloin pieces with slightly seasoned sautéed capsicum, tomato and onion.", 19.90));
        menu.add(new Food("MACHHA CURRY (G, L)", "Paistettuja kuhafilepaloja sinappi-currykastikkeessa\n"
                + "Fried pike-perch fillet pieces in mustard-curry sauce.", 15.50));
        menu.add(new Food("MACHHA CHILLI (G, L)", "Linssi Jauholla kuorrutettuja ja friteerattuja kuhafilee paloja, ja ruskistettua paprikaa ja chiliä tulisessa ja mausteisessa valkosipuli-sipuli-inkivääri-tomaattikastikkeessa.\n"
                + "Deep fried pike-perch fillet- pieces coated with gram batter; and sautéed capsicum and chillies in spicy garlic-onion-ginger-tomato sauce.", 15.00));
        menu.add(new Food("Jhinge MACHHA KORMA (G, L)", "Katkarapuja kookos-tomaatti-cashew-kermakastikkeessa.\n"
                + "Shrimps in creamy -tomato-cashew coconut sauce.", 16.00));
        menu.add(new Food("JHINGE MACHHA MASALA (G, L)", "Paistettuja jättikatkarapuja ja paprikaa valkosipuli-inkivääri sipuli-chili-masalakastikkeessa.\n"
                + "Fried king prawns and capsicum in garlic-ginger-onion-chili-masala sauce.", 16.90));

    }

    private static class foodDataHolder {
        private static final FoodData FOODINSTANCE = new FoodData();
    }
    
    public static FoodData getFoodInstance(){
        return foodDataHolder.FOODINSTANCE;
    }

    public Food getFood(int i) {
        
        return menu.get(i);
    }
    
    public ArrayList<Food> getMenu() {
        return menu;
    }
    

}