package battlerpg.api.lang.btcl;

import battlerpg.api.lang.LanguageSyntaxErrorException;

public class BTCLSyntaxErrorException extends LanguageSyntaxErrorException {

    public BTCLSyntaxErrorException(String errorMessage) {
        super(errorMessage);
    }
    public BTCLSyntaxErrorException(Throwable caused){
        super(caused);
    }
}
