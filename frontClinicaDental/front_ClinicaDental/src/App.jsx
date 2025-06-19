import './App.css'
import VisitanteLayout from './pages/visitante/VisitanteLayout.jsx'
import Login from './Login.jsx'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';



function App() {
  //definimos nuestras rutas a los componentes
  return (
    <Router>
      <Routes>
        <Route path="/" element={<VisitanteLayout />} />
        <Route path="/login" element={<Login />} />
       
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