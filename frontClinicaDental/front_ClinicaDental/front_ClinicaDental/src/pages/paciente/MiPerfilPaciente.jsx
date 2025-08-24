import React from 'react'
import { useState, useEffect } from "react";
import axios from "axios";

export const MiPerfilPaciente = () => {
    const [perfil, setPerfil] = useState({
        username: "",
        password: "",
        rol: "PACIENTE",
        id: "",
        nombre: "",
        apellidos: "",
        email: "",
        telefono: "",
        genero: "",
        fechaNacimiento: "",
        direccion: "",
        codigoPostal: "",
        seguroDental: false,
        numSeguro: "",
        notas: ""
    });

    const [errorMsg, setErrorMsg] = useState("");
    const [successMsg, setSuccessMsg] = useState("");


    const token = localStorage.getItem("token");

    console.log("Token recuperado del localStorage:", token);

    axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    useEffect(() => {
        axios
            .get("http://localhost:8080/paciente/miperfil")
            .then((response) => {
                console.log("Response completa:", response);
                console.log("Solo data:", response.data);
                console.log("Solo paciente:", response.data.data);

                setPerfil(response.data.data);
                setSuccessMsg("Perfil encontrado con éxito.");

            })
            .catch((error) => {
                setErrorMsg(`Error.  \t  ${error.response.data}. Inténtalo de nuevo.`);
                console.error("Error al recuperar el perfil:", error.response);
            });
    }, []); // [] para que se ejecute solo una vez al montar el componente


    return (
        <div>
            <h2>Mi Perfil Paciente</h2>
            {errorMsg && <p style={{ color: "red" }}>{errorMsg}</p>}
            {successMsg && <p style={{ color: "green" }}>{successMsg}</p>}
            <ul>
                <li><b>Nombre:</b> {perfil.nombre}</li>
                <li><b>Apellidos:</b> {perfil.apellidos}</li>
                <li><b>Email:</b> {perfil.email}</li>
                <li><b>Teléfono:</b> {perfil.telefono}</li>
                <li><b>Dirección:</b> {perfil.direccion}</li>
                <li><b>Código Postal:</b> {perfil.codigoPostal}</li>
                <li><b>Seguro Dental:</b> {perfil.seguroDental ? "Sí" : "No"}</li>
                <li><b>Número de Seguro:</b> {perfil.numSeguro}</li>
                <li><b>Notas:</b> {perfil.notas}</li>
            </ul>
        </div>
    )
}

export default MiPerfilPaciente;