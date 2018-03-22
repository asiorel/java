package test;


import java.io.File;

import Roz2.NutritionFacts;
import Roz2.Provider;
import Roz2.Service;
import Roz2.Services;

public class test {

	public static void main(String[] args) {
		//Temat 1 - Services
		/*Services.registerDefaultProvider(Provider.provider());
		Service s = Services.newInstance();*/
		
		//Temat 2 - Builder
		NutritionFacts cocaCola = new NutritionFacts.Buildier(240, 8).
				calories(100).sodium(35).carbohydrante(27).build();
		System.out.println(cocaCola.toString());
		
		//Temat
	}

}
