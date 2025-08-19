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
                            <li><a href="#proximascitas" onClick={cerrarMenu}>Próximas Citas</a></li>
                            <li><a href="#pedircita" onClick={cerrarMenu}>Pedir Cita</a></li>
                            <li><a href="#historial" onClick={cerrarMenu}>Historial</a></li>
                            <li><a href="/paciente/mensajes" onClick={cerrarMenu}>Mensajes</a></li>
                            <li><a href="#ayuda" onClick={cerrarMenu}>Ayuda</a></li>
                            <li><a href="/paciente/miperfil" className='sesion' id="iniciaSesion" onClick={cerrarMenu}>Mi perfil</a></li>
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