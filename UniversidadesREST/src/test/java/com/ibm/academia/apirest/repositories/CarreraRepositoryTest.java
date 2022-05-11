package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CarreraRepositoryTest {

    @Autowired
    private CarreraRepository carreraRepository;

    @Test
    @DisplayName("Test: Busca carreras por nombre")
    void  findCarrerasByNombreContains() {
        //Given
        carreraRepository.save(DatosDummy.carrea01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());

        //when
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("Sistemas");

        //then
        assertThat(((List<Carrera>)expected).size()==2).isTrue();
    }

    @Test
    @Disabled
    void findCarrerasByNombreIgnoreCase() {
    }

    @Test
    @Disabled
    void findCarrerasByCantidadAniosAfter(){
}

}