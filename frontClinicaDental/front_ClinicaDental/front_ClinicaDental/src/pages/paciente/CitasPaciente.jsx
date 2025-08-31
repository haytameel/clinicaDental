import React, { useEffect, useState } from 'react';
import axios from 'axios';
import NavPaciente from './NavPaciente';

function CitasPaciente() {
    const [citas, setCitas] = useState([]);
    const [peticiones, setPeticiones] = useState([]);


    useEffect(() => {
        const token = localStorage.getItem('token');

        axios.get("http://localhost:8080/citas", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        })
            .then(response => {
                setCitas(response.data.data); // Guarda las citas en el estado
                console.log("Citas obtenidas:", response.data.data);
            })
            .catch(error => {
                console.log("Token utilizado:", token);
                console.error("Error al obtener las citas:", error);
            });
    }, []);

    useEffect(() => {
        const token = localStorage.getItem('token');

        axios.get("http://localhost:8080/citas/peticiones", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        })
            .then(response => {
                setPeticiones(response.data.data); // Guarda las citas en el estado
                console.log("Citas obtenidas:", response.data.data);
            })
            .catch(error => {
                console.log("Token utilizado:", token);
                console.error("Error al obtener las citas:", error);
            });
    }, []);


    return (
        <div>
            <NavPaciente />

            <h1>Mis Historial Completo de Citas</h1>
            {citas.length === 0 ? (
                <h2>No tienes ninguna cita registrada.</h2>
            ) : (
                <ul>
                    {citas.map((cita, index) => (
                        <li key={index}>
                            <strong>Fecha:</strong> {cita.fecha} <br />
                            <strong>Desde:</strong> {cita.hora} 
                            <strong>Hasta:</strong> {cita.horaFin}<br />
                            <strong>Dr./Dra. :</strong> {cita.personal}<br />
                            <strong>Estado:</strong> {cita.estado} <br />
                            <strong>Descripción:</strong> {cita.notas}
                            <br /> <br />
                        </li>
                    ))}
                </ul>
            )}
            <br /> <br /> <br />
            <h1>Mis Historial de Peticiones</h1>
            {peticiones.length === 0 ? (
                <h2>No tienes ninguna cita registrada.</h2>
            ) : (
                <ul>
                    {peticiones.map((peticion, index) => (
                        <li key={index}>
                            <strong>Fecha:</strong> {peticion.fecha} <br />
                            <strong>Desde:</strong> {peticion.hora} 
                            <strong>Hasta:</strong> {peticion.horaFin}<br />
                            <strong>Estado:</strong> {peticion.estado} <br />
                            <strong>Descripción:</strong> {peticion.notas}
                            <br /> <br />
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default CitasPaciente;
