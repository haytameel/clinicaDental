import React, { useEffect, useState } from 'react';
import axios from 'axios';

function CitasPaciente() {
    const [citas, setCitas] = useState([]);

    useEffect(() => {
        const token = localStorage.getItem('token');

        axios.get("http://localhost:8080/paciente/citas", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        })
            .then(response => {
                setCitas(response.data); // Guarda las citas en el estado
                console.log("Citas obtenidas:", response.data);
            })
            .catch(error => {
                                    console.log("Token utilizado:", token);

                console.error("Error al obtener las citas:", error);
            });
    }, []);


    return (
        <div>
            <h2>Mis citas</h2>
            {citas.length === 0 ? (
                <p>No tienes citas registradas.</p>
            ) : (
                <ul>
                    {citas.map((cita, index) => (
                        <li key={index}>
                            <strong>Fecha:</strong> {cita.fecha} <br />
                            <strong>Hora:</strong> {cita.hora} <br />
                            <strong>Estado:</strong> {cita.estado} <br />
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
