package com.google.code.yadview;

public interface Predicate {
    public boolean value();
    
    
    
    public static final Predicate TRUE = new Predicate() {
		@Override
		public boolean value() {
			return true;
		}
	};
	
    public static final Predicate FALSE = new Predicate() {
		@Override
		public boolean value() {
			return false;
		}
	};
}
