import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import NavPaciente from './NavPaciente';
import Calendar from './Calendar';



export const HomePaciente = () => {

    const token = localStorage.getItem('token');
    const username = localStorage.getItem('username');


    // redirige al home/login
    const navigate = useNavigate();
    useEffect(() => {
        if (!token) {
            navigate('/');
        }
    }, [token, navigate]);

    return (
        <>
            <NavPaciente />

            <section className="inicio" id="inicio">
                <img className="portada" alt="Portada de la clínica" src="/img/portada.jpeg"></img>
                <div className="textoinicio">
                    <h1>Bienvenido/a de nuevo, <span>{username}</span>
                    </h1>
                </div>
            </section>

            <section className="proximascitas" id="proximascitas">
                <h1 style={{ textAlign: "center" }} >Calendario</h1>
                <Calendar />
            </section>

        </>
    )
}


export default HomePaciente;