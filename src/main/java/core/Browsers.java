package core;

public enum Browsers {
    
    CHROME("chrome"),FIREFOX("firefox"),IE("ie"),SAFARI("safari");

    private final String name;

     Browsers(String name) {
        this.name = name;
    }
    
    public static Browsers getBrowser(String name){
        for (Browsers br: values()) {
            if(br.name.equalsIgnoreCase(name)){
                return br;
            }
        }
        throw new RuntimeException("Browser not found!!!");
    }
}