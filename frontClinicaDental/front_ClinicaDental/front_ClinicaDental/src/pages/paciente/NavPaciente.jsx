import React from 'react'
import { useState } from 'react';
import "../../styles/style.css";
export const NavPaciente = () => {
    const [menuAbierto, setMenuAbierto] = useState(false);

    const toggleMenu = () => {
        setMenuAbierto(!menuAbierto);//invierte
    };

    const cerrarMenu = () => {
        setMenuAbierto(false);
    };

// borramos el token y redirigimos al login
    const logout = () => {
        localStorage.removeItem("token");   
        window.location.href = "/login";    
    };

    return (
        <div className="navbar">
            <div className='logo'>
                <a href="/"><img src="/img/favicon.png" alt="" /></a>

            </div>
            <div className='navlinks'>
                <div className="menu-container">

                    <nav>
                        <ul className={menuAbierto ? 'activo' : 'inactivo'}>

                            <li><a href="#inicio" onClick={cerrarMenu}>Inicio</a></li>
                            <li><a href="/paciente/citas/proximas" onClick={cerrarMenu}>Próximas Citas</a></li>
                            <li><a href="/paciente/citas/pasadas" onClick={cerrarMenu}>Citas pasadas</a></li>
                            <li><a href="#pedircita" onClick={cerrarMenu}>Pedir Cita</a></li>
                            <li><a href="/paciente/citas" onClick={cerrarMenu}>Historial</a></li>
                            <li><a href="/paciente/mensajes" onClick={cerrarMenu}>Mensajes</a></li>
                            <li><a href="#ayuda" onClick={cerrarMenu}>Ayuda</a></li>
                            <li><a href="/paciente/miperfil" className='sesion' id="iniciaSesion" onClick={cerrarMenu}>Mi perfil</a></li>
                            <li><a  className='sesion' id="iniciaSesion" onClick={logout}>Cerrar Sesión</a></li>
                        </ul>
                    </nav>
                    <button className="menu-toggle" onClick={toggleMenu}>
                        {menuAbierto ? 'Cerrar' : 'Menu'}
                    </button>
                </div>
            </div>
        </div>

    )
}
export default NavPaciente;