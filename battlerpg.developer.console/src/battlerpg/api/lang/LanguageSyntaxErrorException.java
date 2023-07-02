package battlerpg.api.lang;

public class LanguageSyntaxErrorException extends RuntimeException{
    public LanguageSyntaxErrorException(String errorMessage){
        super(errorMessage);
    }
    public LanguageSyntaxErrorException(Throwable caused){
        super(caused);
    }
}
