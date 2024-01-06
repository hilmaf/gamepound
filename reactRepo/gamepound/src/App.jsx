import './assets/css/reset.css';
import { BrowserRouter } from 'react-router-dom';
import Wrap from './component/common/Wrap';

function App() {
  return (
    <BrowserRouter>
      <Wrap/>
    </BrowserRouter>
  );
}

export default App;
