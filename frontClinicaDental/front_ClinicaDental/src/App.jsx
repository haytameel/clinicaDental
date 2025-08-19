import './App.css'
import VisitanteLayout from './pages/visitante/VisitanteLayout.jsx'
import Login from './Login.jsx'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePaciente from './pages/paciente/HomePaciente.jsx';
import CitasPaciente from './pages/paciente/CitasPaciente.jsx';



function App() {
  //definimos nuestras rutas a los componentes
  return (
    <Router>
      <Routes>
        <Route path="/" element={<VisitanteLayout />} />
        <Route path="/login" element={<Login />} />
        <Route path="/paciente" element={<HomePaciente />} />
        <Route path="/paciente/citas" element={<CitasPaciente />} />
       
      </Routes>
    </Router>
  )
}

export default App
/*

 <Route path="/admin" element={<AdminHome />} />
 <Route path="/personal" element={<PersonalHome />} />
 <Route path="/paciente" element={<PacienteHome />} />

*/ 