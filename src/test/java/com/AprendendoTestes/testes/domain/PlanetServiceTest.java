package com.AprendendoTestes.testes.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static com.AprendendoTestes.testes.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

//montar o contexto da aplicação escanenando beans que estão sendo usado na classe
//@SpringBootTest(classes=PlanetService.class)

//sempre que usamos  teste de unidade pura para uma melhor otimização não usamos o spring



// na escala usamos o @extendwith
@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {
    //@Autowired
    @InjectMocks
    //ela instancia e todas as dependencia são instanciadas
    private PlanetService service;
    @Mock
    private PlanetRepository repository;


    //operação_estado_retorno

    @Test
    public void createPlanet_whithValidDate_returnsPlanet(){
        //mockando apenas o comportamento da dependencia
        //como o mockito n faz o save ele so simula a a chamada precisando fazer o retorno dessa chamada quando o service.create é acionado
        when(repository.save(PLANET)).thenReturn(PLANET);

        Planet sut = service.create(PLANET);

        //criar um hashcode para a comparação instalando no pom.xml o apache

        assertThat(sut).isEqualTo(PLANET);

    }

}