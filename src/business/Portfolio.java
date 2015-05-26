package business;

public enum Portfolio {
	
	AGGRESSIVE("Aggressive"), VERYCONSERVATIVE("Very Conservative");
    
	private final String display;
	
    private Portfolio(String s) {
        display = s;
    }
    
    @Override
    public String toString() {
        return display;
    }

}
