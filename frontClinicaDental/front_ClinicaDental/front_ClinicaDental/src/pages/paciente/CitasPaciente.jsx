import React, { useEffect, useState } from 'react';
import axios from 'axios';
import NavPaciente from './NavPaciente';

function CitasPaciente() {
    const [citas, setCitas] = useState([]);

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


    return (
        <div>
            <NavPaciente />

            <h2>Mis Historial Completo de Citas</h2>
            {citas.length === 0 ? (
                <p>No tienes ninguna cita registrada.</p>
            ) : (
                <ul>
                    {citas.map((cita, index) => (
                        <li key={index}>
                            <strong>Fecha:</strong> {cita.fecha} <br />
                             <strong>Desde:</strong> {cita.hora} <strong>Hasta:</strong> {cita.horaFin}<br />
                             <strong>Dr./Dra.</strong> {cita.horaFin}<br />
                            <strong>Estado:</strong> {cita.personal} <br />
                            <strong>Descripción:</strong> {cita.notas}
                            <br /> <br />
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default CitasPaciente;
