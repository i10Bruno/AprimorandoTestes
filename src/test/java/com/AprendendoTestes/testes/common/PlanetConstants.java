package com.AprendendoTestes.testes.common;

import com.AprendendoTestes.testes.domain.Planet;

public class PlanetConstants {

    public static final Planet PLANET = new Planet("name","climate","terrain");
    public static final Planet INVALID_PLANET = new Planet(" "," "," ");
    public static final Planet PLANET_id = new Planet(9L,"name","climate","terrain");

}
