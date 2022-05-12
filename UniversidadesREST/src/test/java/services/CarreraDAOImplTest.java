package services;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.repositories.CarreraRepository;
import com.ibm.academia.apirest.services.CarreraDAO;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import com.ibm.academia.apirest.services.CarreraDAOimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
public class CarreraDAOImplTest
{
    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp(){
        carreraRepository= mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOimpl(carreraRepository);
    }

    @Test
    @DisplayName("Test: Buscar Carrera por nombre")
    void findCarrerasByNombreContains()
    {
        //Given
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre)).thenReturn(Arrays.asList(DatosDummy.carrea01(),DatosDummy.carrera03()));

        //When
         List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

         //Then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrea01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository.findCarrerasByNombreContains(nombre));


    }

    @Test
    @DisplayName("Test buscar carreras por nombre No case sensitive")
    void findCarrerasByNombreContainsIgnoreCase()
    {
        //Given
        String nombre= "Ingenieria";
        when(carreraRepository.findCarrerasByNombreIgnoreCase(nombre))
        .thenReturn(Arrays.asList(DatosDummy.carrea01(), DatosDummy.carrera03()));

        //When
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreIgnoreCase(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrea01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByNombreIgnoreCase(nombre);



    }

    @Test
    @DisplayName("Buscar carreras despues de N anios")
    void findCarrerasByCantidadAniosAfter()
    {
        //Given
        Integer cantidad=4;
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(DatosDummy.carrea01(),DatosDummy.carrera03()));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        //Then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrea01());
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);
    }


}
