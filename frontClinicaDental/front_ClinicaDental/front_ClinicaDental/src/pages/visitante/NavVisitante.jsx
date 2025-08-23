import React, { useState } from 'react';
import "../../styles/style.css";
export const NavVisitante = () => {
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
                            <li><a href="#servicios" onClick={cerrarMenu}>Servicios</a></li>
                            <li><a href="#aboutus" onClick={cerrarMenu}>Sobre Nosotros</a></li>
                            <li><a href="#contacto" onClick={cerrarMenu}>Contacto</a></li>
                            <li><a href="/login" className='sesion' id="iniciaSesion" onClick={cerrarMenu}>Iniciar Sesión</a></li>
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
export default NavVisitante;
