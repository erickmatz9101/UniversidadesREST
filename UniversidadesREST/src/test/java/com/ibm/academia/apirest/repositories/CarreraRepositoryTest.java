package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.models.entities.Carrera;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
 public class CarreraRepositoryTest {

    @Autowired
    private CarreraRepository carreraRepository;

    @BeforeEach
    void setUp(){
        carreraRepository.save(DatosDummy.carrea01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());
    }

    @AfterEach
    void tearDown(){
        carreraRepository.deleteAll();
    }

    @Test
    @DisplayName("Test: Busca carreras por nombre")
    void  findCarrerasByNombreContains() {
        //Given
        /*carreraRepository.save(DatosDummy.carrea01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());*/

        //when
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("Sistemas");

        //then
        assertThat(((List<Carrera>)expected).size()==2).isTrue();
    }

    @Test
    @DisplayName("Buscar carreras por nombre No case sensitive")
    void findCarrerasByNombreIgnoreCase() {
        //Given
        /*carreraRepository.save(DatosDummy.carrea01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());*/

        //When
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreIgnoreCase("sistemas");

        //Then
        assertThat(expected.size()==2).isTrue();


    }

    @Test
    @DisplayName("Buscar Carreras mayores a 4 años")
    void findCarrerasByCantidadAniosAfter(){
        //Given
        /*carreraRepository.save(DatosDummy.carrea01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());*/

        //When
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);

        //Then
        assertThat(expected.size()==2).isTrue();


}

}