package com.AprendendoTestes.testes.domain;

import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static com.AprendendoTestes.testes.common.PlanetConstants.PLANET;
import static com.AprendendoTestes.testes.common.PlanetConstants.INVALID_PLANET;
import  static com.AprendendoTestes.testes.common.PlanetConstants.PLANET_id;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    // na validação de dados quando o usuario coloca os dados errados os ifs ficando no controller e no repository
    //por isso os ifs não sao validados no serviceTest , vamos validar o comportamento do repositorio
    //quando é passado dados errados


    //faltou quando os dados ja existem no banco e porque não fazemos a validação no banco pq é pouco performatico
    //Vantagem: Você só vai ao banco uma vez (para tentar salvar). Se falhar, falhou. Você economizou o SELECT prévio.
    //nos so fazemos so uma consulta de salvar se esse dado tiver ja no banco ele ja lança um exception e n salva
    //ao inves de fazer duas consultas a de find e dps a de save nos so fazemos a de save
    //se o dado tiver la vai retornar um erro


    @Test
    public void createPlanet_whithInvalidDate_ThrowsException(){
        when(repository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

      assertThatThrownBy(()->service.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);

    }



    @Test
    public void findByIdPlanet_whenIdNotExists_ThrowsException(){
        when(repository.findById(null)).thenThrow(RuntimeException.class);

        assertThatThrownBy(()->service.findById(null)).isInstanceOf(RuntimeException.class);

    }
    @Test
    public void findByIdPlanet_whenIdExists_ReturnPlanet(){
        when(repository.findById(PLANET_id.getId())).thenReturn(Optional.of(PLANET_id));
        Optional<Planet> sut= service.findById(PLANET_id.getId());
        assertThat(sut).isEqualTo(PLANET_id);
        //deu erro pq um retorna optional que fica dentro de um array e outro retorna o obj

    }


}