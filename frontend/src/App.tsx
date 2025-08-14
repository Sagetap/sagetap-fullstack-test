import './App.css';
import CatsList from './Cats';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<CatsList />} />
        <Route path="/:id" element={null} />
      </Routes>
    </Router>
  );
}

export default App;
