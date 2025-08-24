import React, { useState } from "react";
import axios from "axios";
import "./styles/signup.css";
import 'mdb-react-ui-kit/dist/css/mdb.min.css';

export const SignupForm = () => {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
    nombre: "",
    apellidos: "",
    email: "",
    telefono: "",
    notas: ""
  });

  const [errorMsg, setErrorMsg] = useState("");
  const [successMsg, setSuccessMsg] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value
    }));
    setErrorMsg("");
    setSuccessMsg("");
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("http://localhost:8080/api/auth/signup", formData)
      .then((response) => {
        console.log("Usuario registrado:", response.data);
        setSuccessMsg("Cuenta creada con éxito. Ahora puedes iniciar sesión.");
        setFormData({
          username: "",
          password: "",
          nombre: "",
          apellidos: "",
          email: "",
          telefono: "",
          notas: ""
        });
      })
      .catch((error) => {
        setErrorMsg("Error al registrar el usuario. Intenta de nuevo.");
        console.error("Error en el registro:", error.response);
      });
  };

  return (
    <div className="signup-page">
      <div className="signup-izq">
        <h1>
          ¡Únete a <span>nuestra clínica!</span>
        </h1>
        <p>
          Regístrate como paciente para poder reservar citas, consultar tu
          historial y estar en contacto directo con nuestro equipo. 
        </p>
      </div>

      <div className="signup-der">
        <form onSubmit={handleSubmit}>
          <h2>Regístrate</h2>

          {errorMsg && (
            <div style={{ color: "red", marginBottom: "1rem", fontWeight: "bold" }}>
              {errorMsg}
            </div>
          )}
          {successMsg && (
            <div style={{ color: "green", marginBottom: "1rem", fontWeight: "bold" }}>
              {successMsg}
            </div>
          )}

          <input
            name="username"
            placeholder="Usuario"
            value={formData.username}
            onChange={handleChange}
            required
          />

          <input
            type="password"
            name="password"
            placeholder="Contraseña"
            value={formData.password}
            onChange={handleChange}
            required
          />

          <input
            name="nombre"
            placeholder="Nombre"
            value={formData.nombre}
            onChange={handleChange}
            required
          />

          <input
            name="apellidos"
            placeholder="Apellidos"
            value={formData.apellidos}
            onChange={handleChange}
            required
          />

          <input
            type="email"
            name="email"
            placeholder="Correo electrónico"
            value={formData.email}
            onChange={handleChange}
            required
          />

          <input
            type="tel"
            name="telefono"
            placeholder="Teléfono"
            value={formData.telefono}
            onChange={handleChange}
          />

          <textarea
            name="notas"
            placeholder="Alergias u observaciones"
            value={formData.notas}
            onChange={handleChange}
          />

          <button className="boton" type="submit">
            CREAR CUENTA
          </button>

          <div>
            <h5>
              ¿Ya tienes cuenta? <a href="/login">Inicia sesión</a>
            </h5>
          </div>
        </form>
      </div>
    </div>
  );
};

export default SignupForm;
