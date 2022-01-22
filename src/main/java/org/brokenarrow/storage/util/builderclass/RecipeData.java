package org.brokenarrow.storage.util.builderclass;

import org.brokenarrow.storage.api.builder.RecipeCacheDataAPI;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public final class RecipeData implements RecipeCacheDataAPI {
	private final Set<ItemStack> matrial1;
	private final Set<ItemStack> matrial2;
	private final Set<ItemStack> matrial3;
	private final Set<ItemStack> matrial4;
	private final Set<ItemStack> matrial5;

	private final int amount1;
	private final int amount2;
	private final int amount3;
	private final int amount4;
	private final int amount5;
	private final int totalAmount;
	private final Bulider bulider;

	public RecipeData(Bulider bulider) {
		this.matrial1 = bulider.matrial1;
		this.matrial2 = bulider.matrial2;
		this.matrial3 = bulider.matrial3;
		this.matrial4 = bulider.matrial4;
		this.matrial5 = bulider.matrial5;

		this.amount1 = bulider.amount1;
		this.amount2 = bulider.amount2;
		this.amount3 = bulider.amount3;
		this.amount4 = bulider.amount4;
		this.amount5 = bulider.amount5;
		this.totalAmount = bulider.totalAmount;
		this.bulider = bulider;
	}

	@Override
	public Set<ItemStack> getMatrial1() {
		return matrial1;
	}

	@Override
	public Set<ItemStack> getMatrial2() {
		return matrial2;
	}

	@Override
	public Set<ItemStack> getMatrial3() {
		return matrial3;
	}

	@Override
	public Set<ItemStack> getMatrial4() {
		return matrial4;
	}

	@Override
	public Set<ItemStack> getMatrial5() {
		return matrial5;
	}

	@Override
	public int getAmount1() {
		return amount1;
	}

	@Override
	public int getAmount2() {
		return amount2;
	}

	@Override
	public int getAmount3() {
		return amount3;
	}

	@Override
	public int getAmount4() {
		return amount4;
	}

	@Override
	public int getAmount5() {
		return amount5;
	}

	@Override
	public int getTotalAmount() {
		return totalAmount;
	}

	public Bulider getBulider() {
		return bulider;
	}

	public static class Bulider {

		private Set<ItemStack> matrial1;
		private Set<ItemStack> matrial2;
		private Set<ItemStack> matrial3;
		private Set<ItemStack> matrial4;
		private Set<ItemStack> matrial5;

		private int amount1;
		private int amount2;
		private int amount3;
		private int amount4;
		private int amount5;
		private int totalAmount;


		public Bulider setMatrial1(Set<ItemStack> matrial1) {
			this.matrial1 = matrial1;
			return this;
		}

		public Bulider setMatrial2(Set<ItemStack> matrial2) {
			this.matrial2 = matrial2;
			return this;
		}

		public Bulider setMatrial3(Set<ItemStack> matrial3) {
			this.matrial3 = matrial3;
			return this;
		}

		public Bulider setMatrial4(Set<ItemStack> matrial4) {
			this.matrial4 = matrial4;
			return this;
		}

		public Bulider setMatrial5(Set<ItemStack> matrial5) {
			this.matrial5 = matrial5;
			return this;
		}

		public Bulider setAmount1(int amount1) {
			this.amount1 = amount1;
			return this;
		}

		public Bulider setAmount2(int amount2) {
			this.amount2 = amount2;
			return this;
		}

		public Bulider setAmount3(int amount3) {
			this.amount3 = amount3;
			return this;
		}

		public Bulider setAmount4(int amount4) {
			this.amount4 = amount4;
			return this;
		}

		public Bulider setAmount5(int amount5) {
			this.amount5 = amount5;
			return this;
		}

		public Bulider setTotalAmount(int totalAmount) {
			this.totalAmount = totalAmount;
			return this;
		}

		public RecipeData build() {
			return new RecipeData(this);
		}
	}
}
