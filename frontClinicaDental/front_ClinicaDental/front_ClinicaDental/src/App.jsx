import './styles/style.css'
import VisitanteLayout from './pages/visitante/VisitanteLayout.jsx'
import Login from './Login.jsx'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePaciente from './pages/paciente/HomePaciente.jsx';
import CitasPaciente from './pages/paciente/CitasPaciente.jsx';
import SignupForm from './SignupForm.jsx';
import MiPerfilPaciente from './pages/paciente/MiPerfilPaciente.jsx';



function App() {
  //definimos nuestras rutas a los componentes
  return (
    <Router>
      <Routes>
        <Route path="/" element={<VisitanteLayout />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignupForm />} />
        <Route path="/paciente" element={<HomePaciente />} />
        <Route path="/paciente/citas" element={<CitasPaciente />} />
        <Route path="/paciente/miperfil" element={<MiPerfilPaciente />} />

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