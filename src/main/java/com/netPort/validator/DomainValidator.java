package com.netPort.validator;

public class DomainValidator implements ValidatorInterface<String> {

    public boolean validate(String domain){
        if (!domain.matches("^([A-Z|a-z|-|_|0-9|.]{1,70}).([a-z|A-Z]{1,10})$")
            && !domain.matches("^([0-9]{3}).([0-9]{3}).([0-9]{1,3}).([0-9]{1,3})$")) {
            return false;
        }

        return true;
    }

}
