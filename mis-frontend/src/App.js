import { BrowserRouter } from "react-router-dom";
import { Routes } from "react-router-dom";
import { Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from './pages/Login'; 

function App(){
return (<BrowserRouter>
<Routes>
  <Route path="/login" element={<Login />}>
  </Route>
  </Routes>
  </BrowserRouter>
);
}
export default App;