module interest.simple {
    requires interest.api;

    provides javamodule.interest.api.Interest
        with javamodule.simple.interest.SimpleInterest;
}