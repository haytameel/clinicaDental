import React, { useEffect, useState } from 'react';
import axios from 'axios';
import NavPaciente from './NavPaciente';



export const CitasPasadasPaciente = () => {
 const [citas, setCitas] = useState([]);

    useEffect(() => {
        const token = localStorage.getItem('token');

        axios.get("http://localhost:8080/citas/pasadas", {
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

            <h2>Mis Citas Pasadas</h2>
            {citas.length === 0 ? (
                <p>No has tenido ninguna cita anteriormente.</p>
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


export default CitasPasadasPaciente;