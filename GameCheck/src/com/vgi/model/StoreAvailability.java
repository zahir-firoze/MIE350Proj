package com.vgi.tuple;

import com.vgi.model.Store;

public class StoreAvailability {

		private Store store;
		private int quantity;
		
		public StoreAvailability(){
			this.store = new Store();
			this.quantity = 0;
		}
		public StoreAvailability(Store store, int quantity){
			this.store = new Store(store);
			this.quantity = quantity;
		}
		
		public Store getStore(){
			return store;
		}
		
		public int getQuantity(){
			return quantity;
		}
		
		public void setStore(Store store){
			this.store = new Store(store);
		}
		
		public void setQuantity(int quantity){
			this.quantity = quantity;
		}
		
		
}
