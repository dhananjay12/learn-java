module interest.compound {
    requires interest.api;

    provides javamodule.interest.api.Interest
        with javamodule.compound.interest.CompoundInterest;
}