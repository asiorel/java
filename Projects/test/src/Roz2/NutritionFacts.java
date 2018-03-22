package Roz2;

public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrante;
	
	public static class Buildier{
		private final int servingSize;
		private final int servings;
		
		private int calories  = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrante = 0;
		
		public Buildier(int servingSize, int servings) {
			super();
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Buildier calories(int val) {
			calories = val; return this;
		}
		
		public Buildier fat(int val) {
			fat = val; return this;
		}
		
		public Buildier sodium(int val) {
			sodium = val; return this;
		}
		
		public Buildier carbohydrante(int val) {
			carbohydrante = val; return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Buildier builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrante = builder.carbohydrante;
	}

	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrante=" + carbohydrante + "]";
	}
	
	
}
